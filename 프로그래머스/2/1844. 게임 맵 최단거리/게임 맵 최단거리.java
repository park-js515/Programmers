import java.util.ArrayDeque;

class Solution {
    private static int bfs(int[][] maps) {
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int rows = maps.length;
        int cols = maps[0].length;
        int[][] visited = new int[rows][cols];
        queue.add(new int[] {0, 0});
        visited[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int drow = now[0] + d[i][0];
                int dcol = now[1] + d[i][1];
                
                if (drow < 0 || drow >= rows || dcol < 0 || dcol >= cols || 
                    visited[drow][dcol] != 0 || maps[drow][dcol] == 0) continue;
                visited[drow][dcol] = visited[now[0]][now[1]] + 1;
                if (drow == rows - 1 && dcol == cols - 1) {
                    return visited[drow][dcol];
                }
                queue.add(new int[] {drow, dcol});
            }
        }
        
        return -1;
    }
    public int solution(int[][] maps) {
        return bfs(maps);
    }
}