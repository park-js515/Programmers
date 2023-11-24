class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String loweredS = s.toLowerCase();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = loweredS.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                if (i == 0) {
                    sb.append((char)(ch - 32));
                } else if (loweredS.charAt(i - 1) == ' ') {
                    sb.append((char)(ch - 32));
                } else {
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}