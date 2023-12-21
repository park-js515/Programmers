import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public long solution(int n, int[] times) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int time: times) {
            map.put(time, map.getOrDefault(time, 0) + 1);
        }
        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        
        long begin = 0;
        long end = (long)n * keySet.get(keySet.size() - 1);
        while (begin < end) {
            long mid = (begin + end) / 2;
            long sum = 0;
            for (int key: keySet) {
                sum += mid / key * map.get(key); 
            }
            
            if (sum >= n) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        
        return begin;
    }
}