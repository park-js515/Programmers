class Solution {
    private char getChar(int n) {
        return (char) ('a' + n);
    }
    
    public String solution(int age) {
        String s = age + "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(getChar(s.charAt(i) - '0'));
        }
        
        return sb.toString();
    }
}