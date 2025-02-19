class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int n = 0;
        int len = 24;
        int[] dp = new int[len];
        
        for (int i = 0; i < len; i++) {
            int d = players[i] / m;
            
            if (n < d) {
                int gap = d - n;
                n = d;
                answer += gap;
                if (i + k - 1 < len) {
                    dp[i + k - 1] -= gap;
                }
            }
            
            n += dp[i];
        }
        
        return answer;
    }
}