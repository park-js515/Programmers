class Solution {
    public String solution(String code) {
        int mode = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '1') {
                mode = 1 - mode;
                continue;
            }
            if (i % 2 == mode) {
                sb.append(code.charAt(i));
            }
        }
        return sb.length() != 0 ? sb.toString() : "EMPTY";
    }
}