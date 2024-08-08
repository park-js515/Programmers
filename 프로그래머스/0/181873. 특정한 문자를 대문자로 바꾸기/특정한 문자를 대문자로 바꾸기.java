class Solution {
    public String solution(String my_string, String alp) {
        char a = alp.charAt(0);
        
        return my_string.replace(a, Character.toUpperCase(a));
    }
}