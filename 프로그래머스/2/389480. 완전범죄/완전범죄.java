class Solution {
    public int solution(int[][] info, int n, int m) {
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;
        
        for (int[] a : info) {
            boolean[][] d = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dp[i][j]) {
                        if (a[0] + i < n) {
                            d[a[0] + i][j] = true;
                        }
                        if (a[1] + j < m) {
                            d[i][a[1] + j] = true; 
                        }
                    }
                }
            }
            
            dp = d;
        }
        
        int answer = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j]) {
                    answer = Math.min(answer, i);
                }
            }
        }
        
        return answer != n ? answer : -1;
    }
}