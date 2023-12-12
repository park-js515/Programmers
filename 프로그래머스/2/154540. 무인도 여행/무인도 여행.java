import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private boolean[][] visited;
    private int bfs(int r, int c, int rows, int cols, String[] maps) {
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.add(new int[] {r, c});
        int val = 0;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            val += maps[now[0]].charAt(now[1]) - '0';
            for (int i = 0; i < 4; i++) {
                int dr = now[0] + d[i][0];
                int dc = now[1] + d[i][1];
                
                if (dr < 0 || dr >= rows || dc < 0 || dc >= cols || 
                    visited[dr][dc] || maps[dr].charAt(dc) == 'X') continue;
                visited[dr][dc] = true;
                queue.add(new int[] {dr, dc});
                
            }
        }
        
        return val;
    }
    
    public int[] solution(String[] maps) {
        int rows = maps.length;
        int cols = maps[0].length();
        visited = new boolean[rows][cols];
        
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    answerList.add(bfs(i, j, rows, cols, maps));
                }
            }
        }
        
        if (answerList.size() == 0) {
            return new int[] {-1};
        }
        
        Collections.sort(answerList);
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}