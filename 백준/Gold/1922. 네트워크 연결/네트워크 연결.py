import sys
input = sys.stdin.readline


def find(a):
    global grp

    if grp[a] == a:
        return a

    grp[a] = find(grp[a])
    return grp[a]


def union(a, b):
    global grp

    x = find(a)
    y = find(b)

    grp[y] = x


n = int(input())
m = int(input())
lst = [tuple(map(int, input().split())) for _ in range(m)]
lst.sort(key=lambda x: x[2])
grp = list(range(n + 1))

links = 0
link_sum = 0

for i in range(m):
    a, b, c = lst[i]

    if find(a) != find(b):
        union(a, b)
        links += 1
        link_sum += c

        if links == n - 1:
            break

print(link_sum)