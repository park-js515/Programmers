// dp
// 가장 작은 높이를 마지막에 놓는다고 생각하며 푼다.
// 가장 작은 높이를 맨 앞에 놓으면 구분되는 빌딩(count)가 1 증가한다. -> 1개의 경우
// 그 외의 경우에는 기존의 count에 해당하는 게 증가한다. -> (i - 1) * 2 개의 경우

class Solution {
    private final int MOD = 1_000_000_007;
    
    public int solution(int n, int count) {
        long[][] dp = new long[n + 1][n + 1];
        dp[1][1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i][j + 1] += dp[i - 1][j];
                dp[i][j] += (i - 1) * 2 * dp[i - 1][j];
                dp[i][j + 1] %= MOD;
                dp[i][j] %= MOD;
            }
        }
        
        return (int) dp[n][count];
    }
}