import java.util.*;

class Solution {
    private final int MAX = 100_000;
    private int n, m;
    private int[][] maps, distance;
    
    private void init(int[][] maps) {
        this.n = maps.length;
        this.m = maps[0].length;
        this.maps = maps;
        this.distance = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = MAX;
            }
        }
    }
    
    private int bfs() {
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        ArrayDeque<Node> queue = new ArrayDeque<>();
        
        distance[0][0] = 1;
        queue.add(new Node(0, 0));
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int dr = node.r + d[i][0];
                int dc = node.c + d[i][1];
                
                if (dr < 0 || dr >= n || dc < 0 || dc >= m || 
                    maps[dr][dc] == 0 || distance[node.r][node.c] + 1 >= distance[dr][dc]) {
                    continue;
                }
                
                distance[dr][dc] = distance[node.r][node.c] + 1;
                queue.add(new Node(dr, dc));
            }
        }
        
        return distance[n - 1][m - 1] != MAX ? distance[n - 1][m - 1] : -1;
    }
    
    public int solution(int[][] maps) {
        init(maps);
        
        return bfs();
    }
    
    private class Node {
        int r, c;
        
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}