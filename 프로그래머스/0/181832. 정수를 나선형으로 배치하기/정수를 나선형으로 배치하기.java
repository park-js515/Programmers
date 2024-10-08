class Solution {
    private int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int[][] solution(int n) {
        int num = 1;
        int dir = 0;
        int[][] answer = new int[n][n];
        
        int r = 0;
        int c = 0;
        
        point : while (true) {
            answer[r][c] = num++;
            for (int i = 0; i < 4; i++) {
                int nextDir = (dir + i) % 4;
                int dr = r + d[nextDir][0];
                int dc = c + d[nextDir][1];
                
                if (dr < 0 || dr >= n || dc < 0 || dc >= n || answer[dr][dc] != 0) continue;
                r = dr;
                c = dc;
                dir = nextDir;
                continue point;
            }
            
            break;
        }
        
        return answer;
    }
}