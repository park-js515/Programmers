import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    private int dijkstra(int N, ArrayList<int[]>[] adjList, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] o) -> o[1]));
        int[] visited = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        pq.add(new int[] {1, 0});
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int begin = now[0];
            int cost = now[1];
            if (visited[begin] < cost) continue;
            for (int[] next: adjList[begin]) {
                int end = next[0];
                int nextCost = next[1];
                if (visited[end] > cost + nextCost) {
                    visited[end] = cost + nextCost;
                    pq.add(new int[] {end, cost + nextCost});
                }
            }
        }
        
        int ret = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i] <= k) {
                ret++;
            }
        }
        
        return ret;
    }
    
    public int solution(int N, int[][] road, int K) {
        ArrayList<int[]>[] adjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] r: road) {
            int begin = r[0];
            int end = r[1];
            int cost = r[2];
            adjList[begin].add(new int[] {end, cost});
            adjList[end].add(new int[] {begin, cost});
        }
        
        return dijkstra(N, adjList, K);
    } 
}