class Solution {
    public int solution(int n) {
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        dp1[0] = 1;
        
        for (int i = 1; i < n + 1; i++) {
            dp2[i] = dp1[i - 1];
            for (int j = 0; j < i; j++) {
                dp1[i] += dp1[j] * dp2[i - j];
            }
        }

        return dp1[n];
    }
}