// dp[i][j]: j칸에서부터 i만큼 떨어진 칸까지의 연산의 최대값, 최솟값
// i ~ k, k + 1 ~ i + j -> i + j

import java.util.Arrays;

class Solution {
    public int solution(String arr[]) {
        int len = arr.length;
        int numLen = len / 2 + 1;
        int opLen = len / 2;
        int[] num = new int[numLen];
        int[] op = new int[opLen];
        for (int i = 0; i < numLen; i++) {
            num[i] = Integer.parseInt(arr[i * 2]);
        }
        for (int i = 0; i < opLen; i++) {
            op[i] = arr[i * 2 + 1].equals("-") ? -1 : 1;
        }
        
        int[][] dp1 = new int[numLen][numLen];
        int[][] dp2 = new int[numLen][numLen];
        for (int i = 0; i < numLen; i++) {
            dp1[0][i] = num[i];
            dp2[0][i] = num[i];
        }
        for (int i = 1; i < numLen; i++) {
            Arrays.fill(dp1[i], Integer.MIN_VALUE);
            Arrays.fill(dp2[i], Integer.MAX_VALUE);
        }
        
        for (int i = 1; i < numLen; i++) {
            for (int j = 0; j < numLen; j++) {
                if (i + j >= numLen) break;
                for (int k = j; k < i + j; k++) {
                    if (op[k] == -1) {
                        dp1[i][j] = Math.max(dp1[i][j], dp1[k - j][j] - dp2[i + j - k - 1][k + 1]);
                        dp2[i][j] = Math.min(dp2[i][j], dp2[k - j][j] - dp1[i + j - k - 1][k + 1]);
                    } else {
                        dp1[i][j] = Math.max(dp1[i][j], dp1[k - j][j] + dp1[i + j - k - 1][k + 1]);
                        dp2[i][j] = Math.min(dp2[i][j], dp2[k - j][j] + dp2[i + j - k - 1][k + 1]);
                    }
                }
            }
        }
        
        return dp1[numLen - 1][0];
    }
}