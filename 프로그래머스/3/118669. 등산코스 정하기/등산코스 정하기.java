import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    private int targetSummit = -1;
    private int intensity = Integer.MAX_VALUE;
    private boolean[] isGate, isSummit;
    private ArrayList<int[]>[] adjList;
    
    private void checkSummit(int n, int summit) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1]; 
        });
        boolean[] visited = new boolean[n + 1];
        pq.add(new int[] {summit, 0});
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            if (!visited[node[0]]) {
                visited[node[0]] = true;
            } else {
                continue;
            }
            
            for (int[] next: adjList[node[0]]) {
                if (!visited[next[0]] && !isSummit[next[0]] && next[1] <= intensity) {
                    int nextValue = Math.max(next[1], node[1]);
                    if (isGate[next[0]]) {
                        if (intensity == nextValue) {
                            targetSummit = Math.min(targetSummit, summit);
                        } else if (intensity > nextValue) {
                            intensity = nextValue;
                            targetSummit = summit;
                        }
                    } else {
                        pq.add(new int[] {next[0], nextValue});
                    }
                }
            }
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] path: paths) {
            adjList[path[0]].add(new int[] {path[1], path[2]});
            adjList[path[1]].add(new int[] {path[0], path[2]});
        }
        isGate = new boolean[n + 1];
        isSummit = new boolean[n + 1];
        for (int gate: gates) {
            isGate[gate] = true;
        }
        for (int summit: summits) {
            isSummit[summit] = true;
        }
        for (int s: summits) {
            checkSummit(n, s);
        }
        
        return new int[] {targetSummit, intensity};
    }
}