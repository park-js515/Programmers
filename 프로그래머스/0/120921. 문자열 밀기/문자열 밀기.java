class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        int len = A.length();
        for (int i = 0; i < len; i++) {
            String s = A.substring(len - i, len) + A.substring(0, len - i);
            if (s.equals(B)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}