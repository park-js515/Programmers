import sys
input = sys.stdin.readline


def change(v, gap):
    global tree

    while v != 0:
        tree[v] += gap
        v //= 2


def calc(start, end):
    global tree

    S = 0
    while start <= end:
        if start % 2 == 1:
            S += tree[start]
        if end % 2 == 0:
            S += tree[end]

        start = (start + 1) // 2
        end = (end - 1) // 2

    return S


n, m, k = map(int, input().split())

temp = n
t = 0

while temp > 2 ** t:
    t += 1

T = t + 1
gap1 = 2 ** t
size  = 2 ** T
tree = [0] * size

for i in range(n):
    tree[gap1 + i] = int(input())

for i in range(size - 1, 1, -1):
    tree[i // 2] += tree[i]

for _ in range(m + k):
    a, b, c = map(int, input().split())

    if a == 1:
        temp = b + gap1 - 1
        gap = c - tree[temp]
        change(temp, gap)
    else:
        print(calc(b + gap1 - 1, c + gap1 - 1))