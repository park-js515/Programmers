class Solution {
    private int calc(int t) {
        int h = t / 100;
        int m = (t % 100) + 10;
        if (m >= 60) {
            h++;
            m -= 60;
        }
        
        return h * 100 + m;
    }
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        startday--;
        int answer = n;
        
        for (int i = 0; i < n; i++) {
            int timeLimit = calc(schedules[i]);
            int date = startday;
            for (int j = 0; j < 7; j++) {
                if (date == 5 || date == 6) {
                    date = (date + 1) % 7;
                    continue; 
                }
                if (timeLimit < timelogs[i][j]) {
                    answer--;
                    break;
                }
                date = (date + 1) % 7;
            }
        }
        
        return answer;
    }
}