import sys
input = sys.stdin.readline

T = int(input())
coin = (25, 10, 5, 1)

for _ in range(T):
    C = int(input())
    changes = [0, 0, 0, 0]

    for i in range(4):
        changes[i] = C // coin[i]
        C -= changes[i] * coin[i]

    print(*changes)