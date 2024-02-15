class Solution {
    public int[] solution(long n) {
        String st = Long.toString(n);
        int len = st.length();
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[len - 1 - i] = st.charAt(i) - '0';
        }
        
        return answer;
    }
}