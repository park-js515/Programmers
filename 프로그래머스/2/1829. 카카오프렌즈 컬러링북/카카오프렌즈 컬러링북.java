import java.util.ArrayDeque;

class Solution {
    private int numberOfArea = 0;
    private int maxSizeOfOneArea = 0;
    private boolean[][] visited;
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private void bfs(int m, int n, int[][] picture, int r, int c) {
        int value = picture[r][c];
        int cnt = 1;
        visited[r][c] = true;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c});
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int dr = now[0] + d[i][0];
                int dc = now[1] + d[i][1];
                
                if (dr < 0 || dr >= m || dc < 0 || dc >= n || 
                    visited[dr][dc] || picture[dr][dc] != value) {
                    continue;
                }
                
                visited[dr][dc] = true;
                cnt++;
                queue.add(new int[] {dr, dc});
            }
        }
        
        numberOfArea++;
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    bfs(m, n, picture, i, j);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
}