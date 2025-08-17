import java.util.*;

class Solution {
    private boolean[] visited;
    private int[][] computers;
    
    
    private void bfs(int n, int node) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        this.visited = new boolean[n];
        this.computers = computers;
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                bfs(n, i);
            }
        }
        
        return answer;
    }
}