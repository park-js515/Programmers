class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int val = 0;
            if (Character.isUpperCase(ch)) {
                val = (ch - 'A' + n) % 26 + 'A';
                sb.append((char) val);
            } else if (Character.isLowerCase(ch)) {
                val = (ch - 'a' + n) % 26 + 'a';
                sb.append((char) val);
            } else {
                sb.append(' ');
            }
        }
        
        return sb.toString();
    }
}