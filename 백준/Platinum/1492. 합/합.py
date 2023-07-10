import sys
N, p = map(int,sys.stdin.readline().split())
mod = 10**9+7
pascal = [[1]*(p+2) for _ in range(p+2)]
for i in range(1,p+2):
   for j in range(1,i):
      pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]
dp = [0]*(p+1)
dp[0] = N

for i in range(1,p+1):
   x = (N+1)**(i+1) -1
   for j in range(i):
      x -= pascal[i+1][j] * dp[j] 
   dp[i] = x // (i+1)

print(dp[p] % mod)