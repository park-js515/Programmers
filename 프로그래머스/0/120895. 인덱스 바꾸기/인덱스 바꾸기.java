class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder(my_string);
        char ch1 = my_string.charAt(num1);
        char ch2 = my_string.charAt(num2);
        sb.setCharAt(num1, ch2);
        sb.setCharAt(num2, ch1);
        
        return sb.toString();
    }
}