class Solution {
    private int n;
    private int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int answer = Integer.MAX_VALUE;
    
    private void rotBoard(int[][] board, int r, int c, int k) {
        board[r][c] = (board[r][c] + k + 4) % 4;
        for (int i = 0; i < 4; i++) {
            int dr = r + D[i][0];
            int dc = c + D[i][1];
            
            if (dr < 0 || dr >= n || dc < 0 || dc >= n) continue;
            board[dr][dc] = (board[dr][dc] + k + 4) % 4;
        }
    }
    
    private void revBoard(int[][] board, int r, int c, int k) {
        board[r][c] = (board[r][c] - k + 4) % 4;
        for (int i = 0; i < 4; i++) {
            int dr = r + D[i][0];
            int dc = c + D[i][1];
            
            if (dr < 0 || dr >= n || dc < 0 || dc >= n) continue;
            board[dr][dc] = (board[dr][dc] - k + 4) % 4;
        }
    }
    
    private void dfs(int depth, int[][] board, int[][] rotations) {
        if (depth == n) {
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rotations[i][j] = (4 - board[i - 1][j]) % 4;
                    rotBoard(board, i, j, rotations[i][j]);
                }
            }
            
            int sum = 0;
            int check = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sum += rotations[i][j];
                }
            }
            
            for (int i = 0; i < n; i++) {
                check += board[n - 1][i];
            }
            
            if (check == 0) {
                answer = Math.min(answer, sum);
            }
            
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    revBoard(board, i, j, rotations[i][j]);
                }
            }
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            rotations[0][depth] = i;
            rotBoard(board, 0, depth, i);
            dfs(depth + 1, board, rotations);
            revBoard(board, 0, depth, i);
        }
    } 
    
    public int solution(int[][] clockHands) {
        this.n = clockHands.length;
        dfs(0, clockHands, new int[n][n]);
        
        return answer;
    }
}