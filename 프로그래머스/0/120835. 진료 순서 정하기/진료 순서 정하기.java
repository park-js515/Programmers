
import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = emergency.length;
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = emergency[i];
        }
        Arrays.sort(copy);
        
        
        for (int i = 0; i < len; i++) {
            map.put(copy[i], len - i);
        }
        
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = map.get(emergency[i]);
        }
        
        return answer;
    }
}