class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        while (!s.equals("1")) {
            answer[0]++;
            if (s.contains("0")) {
                int cnt = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '1') {
                        cnt++;
                    } else {
                        answer[1]++;
                    }
                }
                s = Integer.toBinaryString(cnt);             
            } else {
                s = Integer.toBinaryString(s.length());
            }      
        }
        return answer;
    }
}