class Solution {
    private boolean[] v1, v2, v3;
    private int answer = 0;
    
    private void dfs(int n, int depth) {
        if (n == depth) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int t1 = i;
            int t2 = depth + i;
            int t3 = n - 1 - (i - depth);
            if (!v1[t1] && !v2[t2] && !v3[t3]) {
                v1[t1] = true;
                v2[t2] = true;
                v3[t3] = true;
                dfs(n, depth + 1);
                v1[t1] = false;
                v2[t2] = false;
                v3[t3] = false;
            }
        }
        
    }
    
    public int solution(int n) {
        v1 = new boolean[n]; // col
        v2 = new boolean[2 * n - 1]; // row + col
        v3 = new boolean[2 * n - 1]; // n - 1 - (col - row)
        dfs(n, 0);
        
        return answer;
    }
}