import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int pqSize = scoville.length;
        for (int i: scoville) {
            pq.add(i);
        }
        int answer = 0;
        
        while (pqSize > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            if (n1 >= K) {
                return answer;
            }
            answer++;
            int score = n1 + (2 * n2);
            pqSize--;
            pq.add(score);
        }
        
        if (pq.peek() >= K) {
            return answer;
        }
        
        return -1;
    }
}