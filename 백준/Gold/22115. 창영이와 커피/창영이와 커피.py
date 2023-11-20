import sys
input = sys.stdin.readline

N, K = map(int, input().split())
C = [0] + sorted(list(map(int, input().split())), reverse=True)
DP = [[0] * (K + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, K + 1):
        if j == C[i]:
            DP[i][j] = 1
        if DP[i - 1][j] > 0:
            if DP[i][j] == 0:
                DP[i][j] = DP[i - 1][j]
            else:
                DP[i][j] = min(DP[i][j], DP[i - 1][j])

            if j + C[i] <= K:
                DP[i][j + C[i]] = DP[i][j] + 1

if K == 0:
    print(0)
else:
    ans = N + 1
    for i in range(1, N + 1):
        if (DP[i][K] != 0):
            ans = min(ans, DP[i][K])

    print(ans if ans != N + 1 else -1)
