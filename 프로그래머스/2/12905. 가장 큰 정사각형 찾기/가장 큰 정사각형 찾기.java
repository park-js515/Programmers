import java.util.Arrays;

class Solution {
    private int getMin(int[][] board, int r, int c) {
        int min = Math.min(board[r - 1][c - 1], board[r - 1][c]);
        return Math.min(min, board[r][c - 1]);
    }
    
    public int solution(int [][]board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] DP = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            DP[i][0] = board[i][0];
        }
        for (int i = 1; i < cols; i++) {
            DP[0][i] = board[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (board[i][j] == 1) {
                    DP[i][j] = getMin(DP, i, j) + 1;
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, DP[i][j]);
            }
        }

        return max * max;
    }
}