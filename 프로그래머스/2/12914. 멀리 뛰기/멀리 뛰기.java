class Solution {
    private static final int MOD = 1234567;
    public int solution(int n) {
        int[] DP = new int[n + 1];
        DP[1] = 1;
        if (n >= 2) DP[2] = 2;
        for (int i = 3; i <= n; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2]) % MOD;
        }
        return DP[n];
    }
}