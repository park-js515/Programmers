class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb1 = new StringBuilder(my_string);
        StringBuilder sb2 = new StringBuilder(my_string.substring(s, e + 1));
        sb2.reverse();
        sb1.replace(s, e + 1, sb2.toString());
        
        return sb1.toString();
    }
}