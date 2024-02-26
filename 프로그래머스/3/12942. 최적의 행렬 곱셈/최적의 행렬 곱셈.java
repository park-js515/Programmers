class Solution {
    public int solution(int[][] matrix_sizes) {
        int[][] M = matrix_sizes;
        int len = M.length;
        int[][] DP = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                DP[i][j] = Integer.MAX_VALUE;
                if (i == j) {
                    DP[i][j] = 0;
                }
            }
        }
        
        for (int k = 1; k < len; k++) {
            for (int i = 0; i < len - k; i++) {
                for (int j = i; j < i + k; j++) {
                    DP[i][i + k] = Math.min(DP[i][i + k], 
                                            DP[i][j] + DP[j + 1][i + k] + (M[i][0] * M[j][1] * M[i + k][1]));
                }
            }
        }
        
        return DP[0][len - 1];
    }
}