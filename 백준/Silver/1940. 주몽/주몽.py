# 1940 주몽

n = int(input())
m = int(input())

lst = list(map(int, input().split()))
cnt = [0] * m

for i in lst:
    if i < m:
        cnt[i] += 1

left = 1
right = m - 1
res = 0

while right - left >= 1:
    res += cnt[left] if cnt[left] < cnt[right] else cnt[right]
    left += 1
    right -= 1


if left == right:
    res += cnt[left] // 2

print(res)