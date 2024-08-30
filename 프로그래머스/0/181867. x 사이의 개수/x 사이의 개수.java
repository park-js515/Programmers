import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String myString) {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < myString.length(); i++) {
            char ch = myString.charAt(i);
            if (ch == 'x') {
                list.add(cnt);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        list.add(cnt);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}