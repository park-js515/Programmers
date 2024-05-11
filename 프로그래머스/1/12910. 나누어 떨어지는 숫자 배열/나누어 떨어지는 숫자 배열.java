import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int a: arr) {
            if (a % divisor == 0) {
                list.add(a);
            }
        }
        
        Collections.sort(list);
        
        if (list.size() == 0) {
            list.add(-1);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}