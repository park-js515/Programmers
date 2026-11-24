import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int i = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        while (i < arr.length) {
            if (deque.isEmpty()) {
                deque.add(arr[i++]);
                continue;
            }
            
            if (deque.peekLast() < arr[i]) {
                deque.add(arr[i++]);
            } else {
                deque.pollLast();
            }
        }

        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}