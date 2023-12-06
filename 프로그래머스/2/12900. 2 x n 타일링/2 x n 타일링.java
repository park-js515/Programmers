class Solution {
    private static final int MOD = 1000000007;
    public int solution(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        
        int[] DP = new int[n];
        DP[0] = 1;
        DP[1] = 2;
        for (int i = 2; i < n; i++) {
            DP[i] = (DP[i - 2] + DP[i - 1]) % MOD;
        }
        
        return DP[ n - 1];
    }
}