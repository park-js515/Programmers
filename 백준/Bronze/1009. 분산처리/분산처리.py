import sys
input = sys.stdin.readline


T = int(input())
for _ in range(T):
    a, b = map(int, input().split())
    val = pow(a, b, 10)
    print(10 if val == 0 else val)