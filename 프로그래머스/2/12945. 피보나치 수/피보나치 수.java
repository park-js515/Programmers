class Solution {
    private static int[] DP;
    private static final int MOD = 1234567;
    
    public int solution(int n) {
        DP = new int[n + 1];
        DP[1] = 1;
        for (int i = 2; i <= n; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2]) % MOD;
        }
        
        return DP[n];
    }
}