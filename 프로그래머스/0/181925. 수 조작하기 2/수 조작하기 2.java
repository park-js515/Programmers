import java.util.HashMap;
import java.util.Map;


class Solution {
    public String solution(int[] numLog) {
        Map<Integer, Character> map = Map.of(
            1, 'w',
            -1, 's',
            10, 'd',
            -10, 'a'
        );
        
        char[] res = new char[numLog.length - 1];
        for (int i = 0; i < numLog.length - 1; i++) {
            int gap = numLog[i + 1] - numLog[i];
            res[i] = map.get(gap);
        }
        
        return new String(res);
    }
}