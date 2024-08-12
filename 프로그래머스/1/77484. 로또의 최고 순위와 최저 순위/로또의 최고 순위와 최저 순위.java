class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeros = 0;
        int cnt = 0;

        point: for (int i = 0; i < 6; i++) {
            int a = lottos[i];
            if (a == 0) {
                zeros++;
                continue;
            }
            for (int j = 0; j < 6; j++) {
                int b = win_nums[j];
                if (a == b) {
                    cnt++;
                    continue point;
                }
            }
        }
        
        int max = cnt + zeros;
        answer[0] = max >= 2 ? 7 - max : 6;
        answer[1] = cnt >= 2 ? 7 - cnt : 6;
        
        return answer;
    }
}