import java.util.*;

class Solution {
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean[][] toggle = new boolean[102][102];
    private boolean[][] move = new boolean[102][102];
    private int[][] dist = new int[102][102];
    
    private void init(int[][] rectangle) {
        for (int[] rect : rectangle) {
            for (int i = rect[0] * 2; i <= rect[2] * 2; i++) {
                for (int j = rect[1] * 2; j <= rect[3] * 2; j++) {
                    toggle[i][j] = true;
                }
            }

        }
        
        for (int[] rect : rectangle) {
            for (int i = rect[0] * 2 + 1; i <= rect[2] * 2 - 1; i++) {
                for (int j = rect[1] * 2 + 1; j <= rect[3] * 2 - 1; j++) {
                    toggle[i][j] = false;
                }
            }
        }       
        
        for (int i = 1; i < 102; i++) {
            for (int j = 1; j < 102; j++) {
                dist[i][j] = 1_000_000;
                
                if (!toggle[i][j]) continue;
                
                int cnt = 0;
                for (int a = 0; a < 4; a++) {
                    int dr = i + d[a][0];
                    int dc = j + d[a][1];
                    if (toggle[dr][dc]) cnt++;
                }
                
                if (cnt == 2) {
                    move[i][j] = true;
                }
            }
        }
    }
    
    private int bfs(int rs, int cs, int re, int ce) {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(rs, cs));
        System.out.println(rs + " " + cs);
        dist[rs][cs] = 0;
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int dr = point.r + d[i][0];
                int dc = point.c + d[i][1];
                
                if (move[dr][dc] && dist[point.r][point.c] + 1 < dist[dr][dc]) {
                    dist[dr][dc] = dist[point.r][point.c] + 1;
                    queue.add(new Point(dr, dc));
                }
            }
        }

        return dist[re][ce] / 2;
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        init(rectangle);
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    private class Point {
        int r, c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}