import java.util.Arrays;

class Solution {
    public int solution(String[] strs, String t) {
        int tLen = t.length();
        int[] dp = new int[tLen + 1];
        Arrays.fill(dp, 1, tLen + 1, Integer.MAX_VALUE - 1);
        
        int sLen = strs.length;
        int[] strsLen = new int[sLen];
        for (int i = 0; i < sLen; i++) {
            strsLen[i] = strs[i].length();
        }
        
        for (int i = 1; i <= tLen; i++) {
            for (int j = 0; j < sLen; j++) {
                if (i >= strsLen[j] && t.startsWith(strs[j], i - strsLen[j])) {
                    dp[i] = Math.min(dp[i], dp[i - strsLen[j]] + 1);   
                }
            }
        }

        return dp[tLen] == Integer.MAX_VALUE - 1 ? -1 : dp[tLen];
    }
}