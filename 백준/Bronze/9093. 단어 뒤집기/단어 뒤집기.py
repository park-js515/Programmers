import sys
input = sys.stdin.readline


T = int(input())
for t in range(T):
    lst = list(input().split())

    for i in range(len(lst)):
        print(lst[i][::-1], end=" ")
    print()