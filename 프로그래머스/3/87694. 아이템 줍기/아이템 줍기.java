import java.util.ArrayDeque;

class Solution {
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private int bfs(int[][][] road, int rs, int cs, int re, int ce) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {rs, cs});
        int[][] visited = new int[52][52];
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        visited[rs][cs] = 0;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            for (int i = 0; i < 4; i++) {
                int dr = r + d[i][0];
                int dc = c + d[i][1];
                
                if (road[r][c][i] > 0 && visited[r][c] + 1 < visited[dr][dc]) {
                    visited[dr][dc] = visited[r][c] + 1;
                    queue.add(new int[] {dr, dc});
                }
            }
        }
        
        return visited[re][ce];
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][][] road = new int[52][52][4];
        for (int x = 0; x < rectangle.length; x++) {
            int[] r = rectangle[x];
            int X = x + 1;
            int rs = r[1], cs = r[0], re = r[3], ce = r[2];
            for (int i = rs; i < re; i++) {
                if (road[i][cs][1] != -1) {
                    road[i][cs][1] = X;
                }
                if (road[i][ce][1] != -1) {
                    road[i][ce][1] = X;
                }
            }
            for (int i = re; i > rs; i--) {
                if (road[i][cs][0] != -1) {
                    road[i][cs][0] = X;
                }
                if (road[i][ce][0] != -1) {
                    road[i][ce][0] = X;
                }
            }
            for (int i = cs; i < ce; i++) {
                if (road[rs][i][3] != -1) {
                    road[rs][i][3] = X;
                }
                if (road[re][i][3] != -1) {
                    road[re][i][3] = X;
                }
            }
            for (int i = ce; i > cs; i--) {
                if (road[rs][i][2] != -1) {
                    road[rs][i][2] = X;
                }
                if (road[re][i][2] != -1) {
                    road[re][i][2] = X;
                }
            }
            
            for (int i = rs; i <= re; i++) {
                for (int j = cs; j <= ce; j++) {
                    for (int k = 0; k < 4; k++) {
                        int dr = i + d[k][0];
                        int dc = j + d[k][1];
                        if (dr < rs || dr > re || dc < cs || dc > ce) {
                            continue;
                        }
                        if (road[i][j][k] != X) {
                            road[i][j][k] = -1;
                        }
                    }
                }
            }
        }
        
        return bfs(road, characterY, characterX, itemY, itemX);
    }
}