class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int r = board.length;
        int c = board[0].length;
        
        String target = board[h][w];
        for (int i = 0; i < 4; i++) {
            int dr = h + d[i][0];
            int dc = w + d[i][1];
            
            if (dr < 0 || dr >= r || dc < 0 || dc >= c || !target.equals(board[dr][dc])) continue;
            answer++;
        }
        
        return answer;
    }
}