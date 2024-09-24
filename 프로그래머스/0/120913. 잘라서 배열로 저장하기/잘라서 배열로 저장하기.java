import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        List<String> list = new ArrayList<>();
        int len = my_str.length();
        int index = 0;
        
        while (true) {
            if (index + n < len) {
                list.add(my_str.substring(index, index + n));
                index += n;
            } else {
                break;
            }
        }
        
        if (index != len) { list.add(my_str.substring(index, len)); }
        
        return list.toArray(String[]::new);
    }
}