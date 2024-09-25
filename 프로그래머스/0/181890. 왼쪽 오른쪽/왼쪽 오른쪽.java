import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        int len = str_list.length;
        
        for (int i = 0; i < len; i++) {
            String str = str_list[i];
            
            if (str.equals("l")) {
                answer = Arrays.copyOfRange(str_list, 0, i);
                break;
            } else if (str.equals("r")) {
                answer = Arrays.copyOfRange(str_list, i + 1, len);
                break;
            }
        }
        
        return answer;
    }
}