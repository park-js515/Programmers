class Solution {
    private static final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int [][] DP = new int[n][m];
        DP[0][0] = 1;
        for (int[] puddle: puddles) {
            DP[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 && j == 0) || DP[i][j] == -1) continue;
                if (i == 0) {
                    DP[i][j] = DP[i][j - 1];
                } else if (j == 0) {
                    DP[i][j] = DP[i - 1][j];
                } else {
                    if (DP[i - 1][j] == -1 || DP[i][j - 1] == -1) {
                        DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                    } else {
                        DP[i][j] = (DP[i - 1][j] + DP[i][j - 1]) % MOD;
                    }   
                }
            }
        }
        
        return DP[n - 1][m - 1] == -1 ? 0 : DP[n - 1][m - 1];
    }
}