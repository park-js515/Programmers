// dp
// 가장 작은 높이를 마지막에 놓는다고 생각하며 푼다.

class Solution {
    private final int MOD = 1_000_000_007;
    
    public int solution(int n, int count) {
        long[][] dp = new long[n + 1][n + 1];
        dp[1][1] = 1;
        
        long k = 0;
        for (int i = 2; i <= n; i++) {
            k += 2;
            for (int j = 1; j <= i - 1; j++) {
                dp[i][j + 1] += dp[i - 1][j];
                dp[i][j] += k * dp[i - 1][j];
                dp[i][j + 1] %= MOD;
                dp[i][j] %= MOD;
            }
        }
        
        return (int) dp[n][count];
    }
}