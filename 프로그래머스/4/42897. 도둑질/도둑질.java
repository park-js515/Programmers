/*
dp[i]: 현재 위치에서의 최대값
dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);

맨 앞에 0을 추가하여 맨 앞과 그 다음 위치를 비교할 수 있게 한다.
*/

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] case1 = new int[n];
        int[] case2 = new int[n];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        for (int i = 0; i < n - 1; i++) {
            case1[i + 1] = money[i];
        }
        for (int i = 1; i < n; i++) {
            case2[i] = money[i];
        }
        
        dp1[1] = case1[1];
        for (int i = 2; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + case1[i]);
        }
        dp2[1] = case2[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + case2[i]);
        }
        
        return Math.max(dp1[n - 1], dp2[n - 1]);
    }
}