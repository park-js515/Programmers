import java.util.HashSet;

class Solution {
    public String solution(String my_string) {
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}