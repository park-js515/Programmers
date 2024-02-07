// class Solution {
//     private final int MOD = 1_000_000_007;
//     public int solution(int n) {
//         if (n == 2) {
//             return 3;
//         }
//         if (n == 4) {
//             return 11;
//         }
        
//         long[] arr = new long[n / 2];
//         arr[0] = 3;
//         arr[1] = 11;
//         for (int i = 2; i < n / 2; i++) {
//             arr[i] = ((arr[i - 1] * 4) % MOD - arr[i - 2] % MOD + MOD) % MOD;
//         }
        
//         return (int) arr[(n / 2) - 1];
//     }
// }

class Solution {
    public int solution(int n) {
        if (n == 2) {
            return 3;
        }
        if (n == 4) {
            return 11;
        }
        
        int mod = 1000000007;
        long[] dp = new long[5001];

        dp[0] = 1;
        dp[2] = 3;
        for(int i = 4; i <= n; i += 2){
            dp[i] = dp[i - 2] * 3;
            for(int j = i - 4; j >= 0; j -= 2){
                dp[i] += dp[j] * 2;
            }
            dp[i] = dp[i] % mod;
        }
        
        return (int) dp[n];
    }
}