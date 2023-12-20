import java.util.ArrayDeque;

class Solution {
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int solution(String[] maps) {
        int rows = maps.length;
        int cols = maps[0].length();
        int[] start = {0, 0}, exit = {0, 0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maps[i].charAt(j) == 'S') {
                    start = new int[] {i, j};
                } else if(maps[i].charAt(j) == 'E') {
                    exit = new int[] {i, j};
                }
            }
        }
        
        int[][][] visited = new int[rows][cols][2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < 2; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]][0] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dr = now[0] + d[i][0];
                int dc = now[1] + d[i][1];
                
                if (dr < 0 || dr >= rows || dc < 0 || dc >= cols ||
                   maps[dr].charAt(dc) == 'X') {
                    continue;
                }
                if (maps[dr].charAt(dc) == 'L') {
                    if (visited[dr][dc][1] > visited[now[0]][now[1]][now[2]] + 1) {
                        visited[dr][dc][1] = visited[now[0]][now[1]][now[2]] + 1;
                        queue.add(new int[] {dr, dc, 1});
                    }
                } else {
                    if (visited[dr][dc][now[2]] > visited[now[0]][now[1]][now[2]] + 1) {
                        visited[dr][dc][now[2]] = visited[now[0]][now[1]][now[2]] + 1;
                        queue.add(new int[] {dr, dc, now[2]});
                    }
                }
            }
        }
        
        if (visited[exit[0]][exit[1]][1] != Integer.MAX_VALUE) {
            return visited[exit[0]][exit[1]][1];
        } else {
            return -1;
        }
    }
}