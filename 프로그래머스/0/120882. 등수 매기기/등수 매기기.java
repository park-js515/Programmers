class Solution {
    public int[] solution(int[][] score) {
        int[] bucket = new int[201];
        for (int[] s : score) bucket[s[0] + s[1]]++;
        
        int len = score.length;
        int index = 0;
        int[] answer = new int[len];
        for (int i = 200; i >= 0; i--) {
            int cnt = bucket[i];
            
            if (cnt > 0) {
                for (int j = 0; j < len; j++) {
                    if (score[j][0] + score[j][1] == i) {
                        answer[j] = index + 1;
                    }
                }
                index += cnt;
            }
        }
        
        return answer;
    }
}