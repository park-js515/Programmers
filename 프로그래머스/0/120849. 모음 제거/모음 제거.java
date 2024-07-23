import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(String my_string) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            
            if (!list.contains(ch)) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}