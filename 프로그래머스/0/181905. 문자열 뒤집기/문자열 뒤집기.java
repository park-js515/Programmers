class Solution {
    public String solution(String my_string, int s, int e) {
        String s1 = my_string.substring(0, s);
        String s2 = my_string.substring(e + 1, my_string.length());
        StringBuilder sb = new StringBuilder(my_string.substring(s, e + 1));
        sb.reverse();
        
        String answer = s1 + sb.toString() + s2;
        return answer;
    }
}