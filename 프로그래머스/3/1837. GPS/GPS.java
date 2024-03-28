import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int[][] DP = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                DP[i][j] = 200;
            }
        }
        
        
        for (int i = 0; i < m; i++) {
            edge_list[i][0]--;
            edge_list[i][1]--;
        }
        for (int i = 0; i < k; i++) {
            gps_log[i]--;
        }
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge: edge_list) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        
        DP[0][gps_log[0]] = 0;
        for (int i = 1; i < k; i++) {
            int target = gps_log[i];
            for (int j = 0; j < n; j++) {
                int beforeValue = DP[i - 1][j];
                for (int vertex: adjList[j]) {
                    if (vertex == target) {
                        DP[i][vertex] = Math.min(DP[i][vertex], beforeValue);
                    } else {
                        DP[i][vertex] = Math.min(DP[i][vertex], beforeValue + 1);
                    }
                }
            }
        }
        
        int answer = DP[k - 1][gps_log[k - 1]];
        return answer != 200 ? answer : -1;
    }
}