import java.util.Arrays;

class Solution {
    private int[][] cost = {
        {1, 7, 6, 7, 5, 4, 5, 3, 2, 3},
        {7, 1, 2, 4, 2, 3, 5, 4, 5, 6},
        {6, 2, 1, 2, 3, 2, 3, 5, 4, 5},
        {7, 4, 2, 1, 5, 3, 2, 6, 5, 4},
        {5, 2, 3, 5, 1, 2, 4, 2, 3, 5},
        {4, 3, 2, 3, 2, 1, 2, 3, 2, 3},
        {5, 5, 3, 2, 4, 2, 1, 5, 3, 2},
        {3, 4, 5, 6, 2, 3, 5, 1, 2, 4},
        {2, 5, 4, 5, 3, 2, 3, 2, 1, 2},
        {3, 6, 5, 4, 5, 3, 2, 4, 2, 1},
    };
    private int[][][] dp;
    
    private int dfs(int n, String numbers, int idx, int left, int right) {
        if (idx == n) {
            return 0;
        }
        
        if (dp[idx][left][right] != -1) return dp[idx][left][right];
        
        int target = numbers.charAt(idx) - '0';
        int ret = Integer.MAX_VALUE;
        
        if (target != left) {
            ret = Math.min(dfs(n, numbers, idx + 1, left, target) + cost[right][target], ret);
        }
        if (target != right) {
            ret = Math.min(dfs(n, numbers, idx + 1, target, right) + cost[left][target], ret);
        }
        
        return dp[idx][left][right] = ret;
    }
    
    public int solution(String numbers) {
        int n = numbers.length();
        dp = new int[n + 1][10][10];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return dfs(n, numbers, 0, 4, 6);
    }
}