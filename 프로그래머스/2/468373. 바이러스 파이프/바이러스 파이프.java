import java.util.ArrayList;
import java.util.ArrayDeque;

// 인접 리스트를 구분하고, 연 파이프에 대해서만 연산을 처리한다.
// dfs
// k = max_depth
class Solution {
    private ArrayList<Integer>[][] list;
    private boolean[] visited;
    private int answer = 1;
    private int n, k;
    
    private void init(int n, int infection, int[][] edges, int k) {
        list = new ArrayList[4][n + 1];
        visited = new boolean[n + 1];
        visited[infection] = true;
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < n + 1; j++) {
                list[i][j] = new ArrayList<>();
            }
        }
        
        for (int[] edge: edges) {
            int x = edge[0], y = edge[1], type = edge[2];
            list[type][x].add(y);
            list[type][y].add(x);
        }
        
        this.n = n;
        this.k = k;
    }
    
    private void dfs(int depth, int cnt) {
        if (depth == k) {
            answer = Math.max(answer, cnt);
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            ArrayList<Integer> newInfected = new ArrayList<>();
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for (int j = 1; j <= n; j++) {
                if (visited[j]) {
                    queue.add(j);
                }
            }
            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int next: list[i][now]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        newInfected.add(next);
                        queue.add(next);
                    }
                }
            }
            
            dfs(depth + 1, cnt + newInfected.size());
            
            for (int infected: newInfected) {
                visited[infected] = false;
            }
        }
    }
    
    public int solution(int n, int infection, int[][] edges, int k) {
        init(n, infection, edges, k);
        dfs(0, 1);
        
        return answer;
    }
}