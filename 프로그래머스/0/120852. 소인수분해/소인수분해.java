import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
            
            if (n == 1) break;
        }
        
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}