class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = 0;
        int c = ' ';
        
        int cnt1 = 0;
        int cnt2 = 0;
        int temp = 0;
        
        for (int i = 0; i < len; i++) {
            if (temp == 0) {
                cnt1++;
                c = s.charAt(i);
                temp++;
                continue;
            }
            
            temp++;
            if (c == s.charAt(i)) {
                cnt1++;
            } else {
                cnt2++;
            }
            
            if (cnt1 == cnt2) {
                temp = 0;
                answer++;
            }
        }
        
        if (temp > 0) {
            answer++;
        }
        
        return answer;
    }
}