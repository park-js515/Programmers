import sys
input = sys.stdin.readline

N = int(input())
for i in range(1, N + 1):
    temp = "*" * i + " " *  (N - i)
    print(temp + temp[::-1])
for i in range(N - 1, 0, -1):
    temp = "*" * i + " " * (N - i)
    print(temp + temp[::-1])