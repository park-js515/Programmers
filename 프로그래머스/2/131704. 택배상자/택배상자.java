import java.util.ArrayDeque;

class Solution {
    public int solution(int[] order) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int len = order.length;
        for (int i = 0; i <= len; i++) {
            queue.add(i);
        }
        
        int answer = 0;
        for (int i = 0; i < len; i++) {
            int now = order[i];
            
            while (!queue.isEmpty()) {
                if (now > queue.peek()) {
                    stack.add(queue.poll());
                } else {
                    break;
                }
            }
            if (!queue.isEmpty() && now == queue.peek()) {
                queue.poll();
                answer++;
            } else if (now == stack.peekLast()) {
                stack.pollLast();
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}