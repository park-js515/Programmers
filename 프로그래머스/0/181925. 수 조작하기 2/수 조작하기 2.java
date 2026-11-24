import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        Map<Integer, Character> map = new HashMap<>() {{
            put(1, 'w');
            put(-1, 's');
            put(10, 'd');
            put(-10, 'a');
        }};
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < numLog.length; i++) {
            int diff = numLog[i] - numLog[i - 1];
            sb.append(map.get(diff));
        }
        
        return sb.toString();
    }
}