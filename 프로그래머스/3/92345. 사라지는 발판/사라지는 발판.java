// 게임 이론 알고리즘
// (1(현재 자신의 이동) + 나머지 이동) % 2 == 1 승리

class Solution {
    private int[][] board;
    private int N, M;
    private final int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private int dfs(int ar, int ac, int br, int bc) {
        if (board[ar][ac] == 0) {
            return 0;
        }
        
        int ret = 0; // 초기값은 지는 경우로 생각
        board[ar][ac] = 0;
        for (int i = 0; i < 4; i++) {
            int dr = ar + D[i][0];
            int dc = ac + D[i][1];
            
            if (dr < 0 || dr >= N || dc < 0 || dc >= M ||
                board[dr][dc] == 0) {
                continue;
            }
            
            int cnt = 1 + dfs(br, bc, dr, dc);
            if (ret % 2 == 0) { // 지는 경우
                if (cnt % 2 == 0) { // 지는 경우
                    ret = Math.max(ret, cnt);
                } else { // 이기는 경우
                    ret = cnt;
                }
            } else { // 이기는 경우
                if (cnt % 2 == 1) { // 이기는 경우 
                    ret = Math.min(ret, cnt);
                }
            }
        }
        board[ar][ac] = 1;
        
        return ret;
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        this.N = board.length;
        this.M = board[0].length;
        
        return dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
}