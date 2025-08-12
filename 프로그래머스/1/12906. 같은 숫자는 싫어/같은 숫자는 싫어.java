import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        for (int i : arr) {
            if (queue.isEmpty() || queue.peekLast() != i) {
                queue.add(i);
            }
        }
        
        int k = queue.size();
        int[] ans = new int[k];
        for (int i = 0 ; i < k; i++) {
            ans[i] = queue.poll();
        }
        
        return ans;
    }
}