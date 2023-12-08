import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int w = 0;
        int queueSize = 0;
        int idx = 0;
        int len = truck_weights.length;
        int answer = 1;
        
        while (true) {
            if (!queue.isEmpty()) {
                int[] peek = queue.peek();
                if (peek[1] < answer) {
                    System.out.println(peek[1]);
                    queue.poll();
                    w -= peek[0];
                    queueSize--;
                }
            }
        
            if (idx < len) {
                if (queueSize < bridge_length && w + truck_weights[idx] <= weight) {
                    queue.add(new int[] {truck_weights[idx], answer + bridge_length - 1});
                    w += truck_weights[idx++];
                    queueSize++;
                    answer++;
                } else {
                    answer = queue.peek()[1] + 1;
                }
            } else {
                if (!queue.isEmpty()) {
                    int[] peekLast = queue.peekLast();
                    answer = peekLast[1] + 1;
                }
                break;
            }
        }
        
        return answer;
    }
}