import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int a : arr) deque.add(a);
        
        for (int i = 0; i < query.length; i++) {
            int q = query[i];
            int size = deque.size();
            if (i % 2 == 0) {
                for (int j = q + 1; j < size; j++) {
                    deque.pollLast();
                }
            } else {
                for (int j = 0; j < q; j++) {
                    deque.poll();
                }
            }
        }
        
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}