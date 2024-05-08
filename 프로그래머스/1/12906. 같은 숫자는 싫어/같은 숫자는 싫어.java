import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (queue.peekLast() != arr[i]) {
                queue.add(arr[i]);
            }
        }
        
        int size = queue.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = queue.poll();
        }
        return answer;
    }
}