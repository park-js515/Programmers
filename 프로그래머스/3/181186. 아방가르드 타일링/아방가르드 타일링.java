/*
참고: https://tnsn.tistory.com/8

dp[n] = dp[n - 1] + 2 * dp[n - 2] + 5 * dp[n - 3]
+ 2 * (dp[n - 4] + dp[n - 7] + ...)
+ 2 * (dp[n - 5] + dp[n - 8] + ...)
+ 4 * (dp[n - 6] + dp[n - 9] + ...)

dp[n] = dp[n - 1] + 2 * dp[n - 2] + 5 * dp[n - 3]
+ 2 * sum[n - 4] + 2 * sum[n - 5] + 4 * sum[n - 6]

sum[n] = dp[n] + dn[n - 3] + dp[n - 6] + ...
sum[n] = dp[n] + dp[n - 3]

dp[0] = 1 => 0개로 만드는 방법은 1개
dp[1] = 1
*/

class Solution {
    private final int MOD = 1_000_000_007;
    private long[] dp = new long[100_001];
    private long[] sum = new long[100_001];
    
    public int solution(int n) {
        long[] d = {1, 1, 3, 10, 23, 62, 170};
        long[] s = {1, 1, 3, 11, 24, 65, 181};
        if (n <= 6) {
            return (int) d[n];
        }
        
        for (int i = 0; i <= 6; i++) {
            dp[i] = d[i];
            sum[i] = s[i];
        }
        
        for (int i = 7; i <= n; i++) {
            dp[i] = dp[i - 1];
            dp[i] += 2 * dp[i - 2];
            dp[i] += 5 * dp[i - 3];
            dp[i] += 2 * sum[i - 4];
            dp[i] += 2 * sum[i - 5];
            dp[i] += 4 * sum[i - 6];
            dp[i] %= MOD;
            
            sum[i] = dp[i] + sum[i - 3];
            sum[i] %= MOD;
        }
        
        return (int) dp[n];
    }
}