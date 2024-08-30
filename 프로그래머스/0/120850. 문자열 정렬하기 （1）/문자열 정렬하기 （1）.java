import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String my_string) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if (Character.isDigit(ch)) {
                list.add(ch - '0');
            }
        }
        
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}