class Solution {
    boolean solution(String s) {
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;                
            } else {
                if (open > 0) {
                    open--;
                } else {
                    return false;
                }
            }
        }
        
        if (open > 0) return false;
        return true;
    }
}