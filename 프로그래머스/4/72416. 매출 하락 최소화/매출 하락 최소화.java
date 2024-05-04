// dfs + dp
// d[i][0] : i번 노드가 루트인 서브트리에서, i번 노드가 워크숍에 불참하는 경우의 최적해
// d[i][1] : i번 노드가 루트인 서브트리에서, i번 노드가 워크숍에 참석하는 경우의 최적해

import java.util.List;
import java.util.ArrayList;


class Solution {
    private int N;
    private List<Integer>[] adjList;
    private int[] sale;
    private int[][] dp;
    
    private void dfs(int node) {
        for (int child: adjList[node]) {
            dfs(child);
        }
        
        int childSum = 0;
        boolean flag = false;
        int childDifMin = adjList[node].size() > 0 ? Integer.MAX_VALUE : 0;
        for (int child: adjList[node]) {
            childSum += Math.min(dp[child][0], dp[child][1]);
            flag = flag || dp[child][0] > dp[child][1];
            childDifMin = Math.min(childDifMin, dp[child][1] - dp[child][0]);
        }
    
        dp[node][1] = sale[node] + childSum;
        
        if (flag) {
            dp[node][0] = childSum;
        } else {
            dp[node][0] = childSum + childDifMin;
        }
    }
    
    public int solution(int[] sales, int[][] links) {
        this.N = sales.length;
        this.sale = new int[N + 1];        
        for (int i = 0; i < N; i++) {
            sale[i + 1] = sales[i];
        }
        
        adjList = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] link: links) {
            adjList[link[0]].add(link[1]);
        }
        
        dp = new int[N + 1][2];
        dfs(1);
        
        // for (int i = 1; i < N + 1; i++) {
        //     System.out.println(i + ": " + java.util.Arrays.toString(dp[i]));
        // }
        
        return Math.min(dp[1][0], dp[1][1]);
    }
}