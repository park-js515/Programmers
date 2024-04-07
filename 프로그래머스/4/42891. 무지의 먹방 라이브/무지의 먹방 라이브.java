import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

// 몇 번을 돌릴 지 추론 후 적절한 값을 찾는다.

class Solution {
    private final int MAX = 100_000_000;
    private int n;
    private long k;
    private Map<Integer, Long> map;
    
    private long findLowerBound() {
        long start = 1;
        long end = MAX;
        
        while (start < end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int key: map.keySet()) {
                sum += Math.min(mid, key) * map.get(key);
            }
            
            if (sum < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return end;
    }
    
    public int solution(int[] food_times, long k) {
        this.n = food_times.length;
        this.k = k;
        this.map = new HashMap<>();
        long check = 0;
        for (int f: food_times) {
            map.put(f, map.getOrDefault(f, 0L) + 1L);
            check += f;
        }
        
        if (check <= k) {
            return -1;
        }
        
        long lb = findLowerBound();
        long sum = 0;
        for (int key: map.keySet()) {
            sum += Math.min(lb - 1, key) * map.get(key);
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (food_times[i] >= lb) {
                sum++;
                
                if (sum == k + 1) {
                    answer = i + 1;
                    break;
                }
            }
        }
        
        if (sum < k + 1) {
            lb++;
            for (int i = 0; i < n; i++) {
                if (food_times[i] >= lb) {
                    sum++;
                }
                
                if (sum == k + 1) {
                    answer = i + 1;
                    break;
                }
            }
        }

        return answer;
    }
}