import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public long solution(int[] a, int[][] edges) {
        int len = a.length;
        long[] arr = new long[len];
        for (int i = 0; i < len; i++) {
            arr[i] = a[i];
        }
        if (Arrays.stream(arr).sum() != 0) {
            return -1;
        }
        
        int[] degree = new int[len];
        ArrayList<Integer>[] adjList = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
            adjList[u].add(v);
            adjList[v].add(u);
        }
        
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Long.compare(o1[2], o2[2]);
        });
        for (int i = 0; i < len; i++) {
            if (degree[i] == 1) {
                pq.add(new long[] {i, arr[i], Math.abs(arr[i])});
            }
        }
        
        long cnt = 0;
        while (!pq.isEmpty()) {
            int node = (int) pq.poll()[0];
            for (int child: adjList[node]) {
                if (degree[node] == 0) {
                    break;
                }
                if (degree[child] > 0) {
                    degree[node]--;
                    degree[child]--;
                    if (degree[node] == 0) {
                        cnt += Math.abs(arr[node]);
                        arr[child] += arr[node];
                        arr[node] = 0;
                    }
                    if (degree[child] == 1) {
                        pq.add(new long[] {child, arr[child], Math.abs(arr[child])});
                    }
                }
            }
        }
        
        return cnt;
    }
}