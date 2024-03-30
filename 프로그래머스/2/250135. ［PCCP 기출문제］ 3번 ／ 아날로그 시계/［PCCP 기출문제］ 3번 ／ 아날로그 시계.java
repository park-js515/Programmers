class Solution {
    private int getSecond(int h, int m, int s) {
        m += h * 60;
        s += m * 60;
        return s;
    }
    
    private int countAlarm(int time) {
        int hAlarms = time * 719 / 43200;
        int mAlarms = time * 59 / 3600;
        int penalty = 43200 <= time ? 2 : 1;
        
        return hAlarms + mAlarms - penalty;
    }
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int t1 = getSecond(h1, m1, s1);
        int t2 = getSecond(h2, m2, s2);
        
        int answer = countAlarm(t2) - countAlarm(t1);
        if (t1 % 43200 == 0 && t1 % 3600 == 0) {
            answer++;
        }
        
        return answer;
    }
}