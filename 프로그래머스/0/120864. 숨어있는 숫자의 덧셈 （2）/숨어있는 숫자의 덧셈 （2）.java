class Solution {
    public int solution(String my_string) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else if (sb.length() > 0){
                answer += Integer.parseInt(sb.toString());
                sb = new StringBuilder();
            }
        }
        
        if (sb.length() > 0) {
            answer += Integer.parseInt(sb.toString());
        }
        
        return answer;
    }
}