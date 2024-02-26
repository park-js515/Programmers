// DP[i][0]: 마지막이 자유롭지 않을 때의 경우 수
// DP[i][1]: 마지막이 자유로울 때의 경우의 수

class Solution {
    private final int MOD = 10007;
    public int solution(int n, int[] tops) {
        int[][] DP = new int[n + 1][2];
        DP[0][1] = 1;
        for (int i = 0; i < n; i++) {
            int top = tops[i];
            int k = i + 1;
            DP[k][0] = (DP[i][0] + DP[i][1]) % MOD;
            if (top == 0) {
                DP[k][1] = (DP[i][0] + DP[i][1] * 2) % MOD;
            } else {
                DP[k][1] = (DP[i][0] * 2 + DP[i][1] * 3) % MOD;
            }
        }
        
        return (DP[n][0] + DP[n][1]) % MOD;
    }
}