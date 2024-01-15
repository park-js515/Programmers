class Solution {
    private final int[] sale = {10, 20, 30, 40};
    private int[] answer = {0, 0};
    private int[][] Users;
    private int[] Emoticons;
    private int[] saleArr;
    private void dfs(int eLen, int depth) {
        if (depth == eLen) {
            int emoticonPlus = 0;
            int emoticonAmount = 0;
            for (int[] user: Users) {
                int sum = 0;
                for (int i = 0; i < eLen; i++) {
                    if (user[0] <= saleArr[i]) {
                        sum += (100 - saleArr[i]) * Emoticons[i] / 100;
                    }
                }
                if (sum >= user[1]) {
                    emoticonPlus++;
                } else {
                    emoticonAmount += sum;
                }
            }
            
            if (emoticonPlus > answer[0]) {
                answer = new int[] {emoticonPlus, emoticonAmount};
            } else if (emoticonPlus == answer[0]) {
                answer[1] = Math.max(answer[1], emoticonAmount);
            }
            
            return;
        }
        
        for (int saleRate: sale) {
            saleArr[depth] = saleRate;
            dfs(eLen, depth + 1);
        }
    }
    public int[] solution(int[][] users, int[] emoticons) {
        int usersLen = users.length;
        int eLen = emoticons.length;
        saleArr = new int[eLen];
        Users = users;
        Emoticons = emoticons;
        
        dfs(eLen, 0);
        return answer;
    }
}