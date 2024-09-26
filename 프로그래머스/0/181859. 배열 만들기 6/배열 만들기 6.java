import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        int index = 0;
        
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        
        while (index < len) {
            if (stk.isEmpty()) {
                stk.add(arr[index++]);
                continue;
            }
            
            if (stk.peekLast() == arr[index]) {
                stk.pollLast();
            } else {
                stk.add(arr[index]);
            }
            index++;
        }
        
        if (stk.isEmpty()) return new int[] {-1};
        return stk.stream().mapToInt(Integer::intValue).toArray();
    }
}