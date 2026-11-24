import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        int length = my_string.length();
        List<String> list = new ArrayList<>();
        
        for (int i = length - 1; i >= 0; i--) {
            list.add(my_string.substring(i, length));
        }
        Collections.sort(list);
        
        return list.stream().toArray(String[]::new);
    }
}