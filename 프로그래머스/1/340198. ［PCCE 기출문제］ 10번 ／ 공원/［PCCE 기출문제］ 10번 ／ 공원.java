class Solution {
    public int solution(int[] mats, String[][] park) {
        int r = park.length;
        int c = park[0].length;
        int[][] dp = new int[r][c];
        int max = 0;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (park[i][j].equals("-1")) {
                    dp[i][j] = 1;
                    max = 1;    
                };
            }
        }
        
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (dp[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        int answer = -1;
        for (int mat : mats) {
            if (mat <= max) {
                answer = Math.max(answer, mat);
            }
        }
        
        return answer;
    }
}