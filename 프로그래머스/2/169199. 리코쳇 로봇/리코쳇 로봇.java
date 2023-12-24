import java.util.ArrayDeque;

class Solution {
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int bfs(String[] board, int rows, int cols, int[] R, int[] G) {
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        
        visited[R[0]][R[1]] = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(R);
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dr = now[0];
                int dc = now[1];
                int nextCnt = visited[now[0]][now[1]] + 1;
                while(true) {
                    dr += d[i][0];
                    dc += d[i][1];
                    if (dr < 0 || dr >= rows || dc < 0 || dc >= cols ||
                       board[dr].charAt(dc) == 'D') {
                        dr -= d[i][0];
                        dc -= d[i][1];
                        if (visited[dr][dc] > nextCnt) {
                            visited[dr][dc] = nextCnt;
                            queue.add(new int[] {dr, dc});
                        }
                        break;
                    }
                }
            }
        }
        
        return visited[G[0]][G[1]] == Integer.MAX_VALUE ? -1 : visited[G[0]][G[1]];
    }
    
    public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();
        int[] R = {0, 0}, G = {0, 0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = board[i].charAt(j);
                if (ch == 'R') {
                    R = new int[] {i, j};
                } else if (ch == 'G') {
                    G = new int[] {i ,j};
                }
            }
        }
        
        return bfs(board, rows, cols, R, G);
    }
}