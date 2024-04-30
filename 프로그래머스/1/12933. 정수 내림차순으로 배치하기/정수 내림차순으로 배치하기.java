import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        List<Long> list = new ArrayList<>();
        
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        long answer = 0;
        for (int i = 0; i < list.size(); i++) {
            answer *= 10;
            answer += list.get(i);
        }
        
        return answer;
    }
}