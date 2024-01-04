import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    private int[] dijkstra(ArrayList<Integer>[] adjList, int dest, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        int[] dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        pq.add(new int[] {dest, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (dist[now[0]] <= now[1]) {
                continue;
            }
            dist[now[0]] = now[1];
            
            for (int i: adjList[now[0]]) {
                if (dist[i] > now[1] + 1) {
                    pq.add(new int[] {i, now[1] + 1});
                }
            }
        }
        
        return dist;
    } 
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] road: roads) {
            adjList[road[0]].add(road[1]);
            adjList[road[1]].add(road[0]);
        }
        
        int[] dist = dijkstra(adjList, destination, n);
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]] != Integer.MAX_VALUE ? dist[sources[i]] : -1;
        }
        
        return answer;
    }
}