class Solution {
    public String solution(int a, int b) {
        int[] calender = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] date = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int cnt = b;
        for (int i = 0; i < a - 1; i++) {
            cnt += calender[i];
        }
        cnt--;
        cnt %= 7;
        
        return date[cnt];
    }
}