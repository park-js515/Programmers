import java.util.*;

class Solution {
    private int n;
    private Hint[] hintList;
    private int[] tickets;
    private int answer;
    
    
    private void init(int[][] cost, int[][] hint) {
        n = cost.length;
        hintList = new Hint[n - 1];
        tickets = new int[n];
        
        for (int i = 0; i < n - 1; i++) {
            hintList[i] = new Hint(hint[i]);
        }
        
        answer = 0;
        for (int i = 0; i < n; i++) {
            answer += cost[i][0];
        }
    }
    
    private void dfs(int depth, int sum, int[][] cost) {
        if (depth == n) {
            answer = Math.min(answer, sum);
            return;
        }
        
        // 안산다
        dfs(depth + 1, sum + cost[depth][Math.min(n - 1, tickets[depth])], cost);
        
        // 산다
        if (depth < n - 1) {
            for (Map.Entry<Integer, Integer> entry: hintList[depth].cnt.entrySet()) {
                tickets[entry.getKey()] += entry.getValue();
            }
            dfs(depth + 1, 
                sum + cost[depth][Math.min(n - 1, tickets[depth])] + hintList[depth].cost, 
                cost);
            for (Map.Entry<Integer, Integer> entry: hintList[depth].cnt.entrySet()) {
                tickets[entry.getKey()] -= entry.getValue();
            }
        }
    }
    
    public int solution(int[][] cost, int[][] hint) {
        init(cost, hint);
        dfs(0, 0, cost);
        
        return answer;
    }
    
    private class Hint {
        int cost;
        Map<Integer, Integer> cnt;
        
        Hint(int[] h) {
            this.cost = h[0];
            cnt = new HashMap<>();
            
            for (int i = 1; i < h.length; i++) {
                int ticket = h[i] - 1;
                cnt.put(ticket, cnt.getOrDefault(ticket, 0) + 1);
            }
        }
    }
}