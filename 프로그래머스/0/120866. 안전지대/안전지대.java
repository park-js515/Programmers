class Solution {
    public int solution(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        boolean[][] check = new boolean[r][c];
        int answer = r * c;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 0) continue;
                
                for (int a = -1; a <= 1; a++) {
                    for (int b = -1; b <= 1; b++) {
                        
                        int dr = i + a;
                        int dc = j + b;
                        if (dr < 0 || dr >= r || dc < 0 || dc >= c || check[dr][dc]) continue;
                        
                        check[dr][dc] = true;
                        answer--;
                    }
                }
            }
        }
        
        return answer;
    }
}