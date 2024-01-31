class Solution {
    private final int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        if (m == 1 && n == 1) {
            return 1;
        }
        
        int[][] d = {{1, 0}, {0, 1}};
        int[][][] DP = new int[m][n][2];
        if (m > 1) {
            DP[0][1][1] = 1;
        }
        if (n > 1) {
            DP[1][0][0] = 1;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sign = cityMap[i][j];
                if ((i == 0 && j == 0) || sign == 1) {
                    continue;
                }
                
                int sum = (DP[i][j][0] + DP[i][j][1]) % MOD;
                for (int k = 0; k < 2; k++) {
                    int dr = i + d[k][0];
                    int dc = j + d[k][1];
                    if (dr >= m || dc >= n) {
                        continue;
                    }
                    if (sign == 0) {
                        DP[dr][dc][k] = (DP[dr][dc][k] + sum) % MOD;
                    } else {
                        DP[dr][dc][k] = (DP[dr][dc][k] + DP[i][j][k]) % MOD;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < 2; i++) {
            answer = (answer + DP[m - 1][n - 1][i]) % MOD;
        }
        
        return answer;
    }
}