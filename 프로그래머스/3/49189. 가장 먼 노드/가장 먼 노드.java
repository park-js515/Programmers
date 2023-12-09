import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] e: edge) {
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        
        int[] visited = new int[n + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = 1;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int i: adjList[now]) {
                if (visited[i] == 0) {
                    visited[i] = visited[now] + 1;
                    queue.add(i);
                }
            }
        }
        
        int answer = 0;
        int max = 0;
        for (int i: visited) {
            max = Math.max(max, i);
        }
        for (int i: visited) {
            if (i == max) {
                answer++;
            }
        }
        return answer;
    }
}