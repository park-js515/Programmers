class Solution {
    private boolean[] visited;
    private int answer = 0;
    private int n;
    private int[][] q;
    private int[] ans;
    
    private void dfs(int depth, int k) {
        if (depth == 5) {
            if (check()) {
                answer++;                
            }
            return;
        }
        
        for (int i = k; i <= n; i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
    
    private boolean check() {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int j : q[i]) {
                if (visited[j]) {
                    cnt++;
                }
            }
            
            if (cnt != ans[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        this.visited = new boolean[n + 1];
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        dfs(0, 1);
        
        return answer;
    }
}