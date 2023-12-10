class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
        if (len <= 3) {
            int max = 0;
            for (int i = 0; i < len; i++)  {
                max = Math.max(max, sticker[i]);
            }
            
            return max;
        }
        
        int max = 0;
        for (int i = 0; i < 3; i++) {
            int[] DP = new int[len];
            DP[i] = sticker[i];
            for (int j = i; j < len; j++) {
                if (DP[j] == 0) continue;
                int maxRange = Math.min(j + 4, len);
                for (int k = j + 2; k < maxRange; k++) {
                    if (i == 0 && k == len - 1) continue;
                    DP[k] = Math.max(DP[k], DP[j] + sticker[k]);
                }
            }
            for (int val: DP) {
                max = Math.max(max, val);
            }
        }
        
        return max;
    }
}