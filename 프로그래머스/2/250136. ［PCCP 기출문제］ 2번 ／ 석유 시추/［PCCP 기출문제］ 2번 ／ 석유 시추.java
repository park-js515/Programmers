import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
    private int[][] visited;
    private ArrayList<Integer> list = new ArrayList<>();
    private int idx = 1;
    private int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    private void bfs(int r, int c, int n, int m, int[][] land) {
        int cnt = 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c});
        visited[r][c] = idx;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int dr = now[0] + d[i][0];
                int dc = now[1] + d[i][1];
                
                if (dr < 0 || dr >= n || dc < 0 || dc >= m || 
                    visited[dr][dc] != 0 || land[dr][dc] == 0) {
                    continue;
                }
                
                visited[dr][dc] = idx;
                cnt++;
                queue.add(new int[] {dr, dc});
            }
        }
        
        list.add(cnt);
        idx++;
    }
    
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        visited = new int[n][m];
        list.add(0);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && visited[i][j] == 0) {
                    bfs(i, j, n, m, land);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean[] pipes = new boolean[idx];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                int node = visited[j][i];
                if (node != 0 && !pipes[node]) {
                    pipes[node] = true;
                    cnt += list.get(node);
                }
            }
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}