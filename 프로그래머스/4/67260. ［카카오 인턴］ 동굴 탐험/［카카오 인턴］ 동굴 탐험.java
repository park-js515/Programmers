// 1. 선행 정점이 없는 경우
// 2. 선행 정점이 방문된 경우
// 3. 선행 정점이 방문되지 않은 경우

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    private List<Integer>[] adjList;
    private int[] next;
    private int[] orderList;
    private boolean[] visited;
    
    private void init(int n, int[][] path, int[][] order) {
        this.adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            this.adjList[i] = new ArrayList<>();
        }
        for (int[] p: path) {
            this.adjList[p[0]].add(p[1]);
            this.adjList[p[1]].add(p[0]);
        }
        orderList = new int[n];
        for (int[] o: order) {
            this.orderList[o[1]] = o[0];
        }
        
        this.next = new int[n];
        this.visited = new boolean[n];
    }
    
    public boolean solution(int n, int[][] path, int[][] order) {
        init(n, path, order);
        
        int cnt = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited[orderList[node]] && node != orderList[node]) {
                next[orderList[node]] = node;
                continue;
            }
            
            visited[node] = true;
            cnt++;
            if (next[node] != 0) { // 선행 정점이 방문되면 후행 정점을 큐에 넣어준다.
                queue.add(next[node]);
            }
            for (int i: adjList[node]) {
                if (!visited[i]) {
                    queue.add(i);
                }
            }
        }
        
        System.out.println(cnt);
        return cnt == n ? true : false;
    }
}