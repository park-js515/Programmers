import java.util.Arrays;

class Solution {
    private final int MOD = 1_000_000_007;
    public int solution(int n, int[] money) {
        Arrays.sort(money);
        int[] DP = new int[n + 1];  
        DP[0] = 1;
        for (int m: money) {
            for (int i = 0; i <= n; i++) {
                if (i >= m) {
                    DP[i] += DP[i - m];
                    DP[i] %= MOD;
                }
            }
        }
        
        return DP[n];
    }
}