// HashMap + find
import java.util.HashMap;
import java.util.Map;


class Solution {
    private Map<Long, Long> map = new HashMap<>();
    
    private long find(long a) {
        if (!map.containsKey(a)) {
            map.put(a, a + 1);
            return a;
        }
        
        map.put(a, find(map.get(a)));
        return map.get(a);
    }
    
    public long[] solution(long k, long[] room_number) {
        int len = room_number.length;
        long[] answer = new long[len];
        
        for (int i = 0; i < len; i++) {
            long t = room_number[i];
            answer[i] = find(t);
        }
        
        return answer;
    }
}