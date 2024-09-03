import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            if (!strArr[i].contains("ad")) {
                list.add(strArr[i]);
            }
        }
        
        return list.toArray(String[]::new);
    }    
}