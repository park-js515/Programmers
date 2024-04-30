class Solution {
    boolean solution(String s) {
        int cnt1 = 0, cnt2 = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == 'p' || ch == 'P') {
                cnt1++;
            }
            if (ch == 'y' || ch == 'Y') {
                cnt2++;
            }
        }
        
        return cnt1 == cnt2;
    }
}