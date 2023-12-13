class Solution {
    private int answer = Integer.MAX_VALUE;
    private void dfs(int storey, int cost) {
        if (answer <= cost) return;
        if (storey == 0) {
            answer = Math.min(answer, cost);
            return;
        }
        
        int n = storey % 10;
        int m = 10 - n;
        dfs((storey - n) / 10, cost + n);
        dfs((storey + m) / 10, cost + m);
    }
    
    public int solution(int storey) {
        dfs(storey, 0);
        
        return answer;
    }
}