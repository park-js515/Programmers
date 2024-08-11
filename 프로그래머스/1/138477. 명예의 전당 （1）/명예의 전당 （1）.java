import java.util.PriorityQueue;
import java.util.Deque;
import java.util.Arrays;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);
            while (queue.size() > k) {
                queue.poll();
            }
            
            answer[i] = queue.peek();
        }
        
        return answer;
    }
}