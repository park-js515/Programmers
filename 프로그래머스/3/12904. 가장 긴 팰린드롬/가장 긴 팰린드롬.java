class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = 0;
        for (int i = 0; i < len; i++) {
            int cnt = 1;
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                cnt += 2;
                left--;
                right++;
            }
            answer = Math.max(answer, cnt);
        }
        for (int i = 0; i < len - 1; i++) {
            int left = i;
            int right = i + 1;
            int cnt = 0;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                cnt += 2;
                left--;
                right++;
            }
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}