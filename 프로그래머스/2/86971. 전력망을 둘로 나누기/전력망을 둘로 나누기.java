import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
    private boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            ArrayList<Integer>[] list = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                list[j] = new ArrayList<>();
            }
            for (int j = 0; j < n - 1; j++) {
                if (j != i) {
                    int begin = wires[j][0];
                    int end = wires[j][1];
                    list[begin].add(end);
                    list[end].add(begin);
                }
            }
            
            boolean[] visited = new boolean[n + 1];
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            visited[1] = true;
            queue.add(1);
            int cnt = 1;
            
            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int node: list[now]) {
                    if (!visited[node]) {
                        visited[node] = true;
                        queue.add(node);
                        cnt++;
                    }
                }
            }
            
            answer = Math.min(answer, Math.abs(n - (2 * cnt)));
        }
        
        return answer;
    }
}