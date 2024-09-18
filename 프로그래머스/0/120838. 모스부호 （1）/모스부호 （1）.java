class Solution {
    private String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        String[] split = letter.split(" ");
        
        for (String s : split) {
            for (int i = 0; i < 26; i++) {
                if (s.equals(morse[i])) {
                    sb.append((char) ('a' + i));
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}