import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        
        int index = 0;
        while (index < len) {
            if (stk.isEmpty()) {
                stk.add(arr[index++]);
                continue;
            }
            
            if (stk.peekLast() < arr[index]) {
                stk.add(arr[index++]);
            } else {
                stk.pollLast();
            }
        }
        
        return stk.stream().mapToInt(Integer::intValue).toArray();
    }
}