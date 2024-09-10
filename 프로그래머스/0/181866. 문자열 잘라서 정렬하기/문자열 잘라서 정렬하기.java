import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String[] solution(String myString) {
        myString = myString.replaceAll("x{1,}", "x");
        String[] split = myString.split("x");
        
        ArrayList<String> list = new ArrayList<>();
        for (String s : split) {
            if (!s.isEmpty()) {
                list.add(s);
            }
        }
        
        Collections.sort(list);
        return list.stream().toArray(String[]::new);
    }
}