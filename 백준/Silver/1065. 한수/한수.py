import sys
input = sys.stdin.readline

N = int(input())
lst = [0 for _ in range(1001)]

for i in range(1, 100):
    lst[i] = 1

for i in range(11, 100):
    d10 = i // 10
    d1 = i % 10
    gap = d1 - d10

    if 0 <= d1 + gap < 10:
        lst[i * 10 + d1 + gap] = 1

cnt = 0
for i in range(1, N + 1):
    cnt += lst[i]

print(cnt)