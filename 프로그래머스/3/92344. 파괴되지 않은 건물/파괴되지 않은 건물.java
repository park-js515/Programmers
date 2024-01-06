class Solution {
    public int solution(int[][] board, int[][] skill) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] arr = new int[rows][cols];
        
        for (int[] s: skill) {
            int type = s[0], r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4];
            int degree = type == 1 ? -s[5] : s[5];
            arr[r1][c1] += degree;
            if (r2 + 1 < rows) {
                arr[r2 + 1][c1] -= degree;
            }
            if (c2 + 1 < cols) {
                arr[r1][c2 + 1] -= degree;
            }
            if (r2 + 1 < rows && c2 + 1 < cols) {
                arr[r2 + 1][c2 + 1] += degree;
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }
        for (int j = 0; j < cols; j++) {
            for (int i = 1; i < rows; i++) {
                arr[i][j] += arr[i - 1][j];
            }
        }

        int answer = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] + arr[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}