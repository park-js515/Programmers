class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int cnt = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ' ') {
                cnt = -1;
                sb.append(' ');
            } else {
                cnt++;
                if (cnt % 2 == 0) {
                    sb.append(Character.toUpperCase(ch));
                } else {
                    sb.append(Character.toLowerCase(ch));
                }
            }
        }
        
        return sb.toString();
    }
}