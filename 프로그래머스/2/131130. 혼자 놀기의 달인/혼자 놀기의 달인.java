import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int solution(int[] cards) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        int len = cards.length;
        int[] C = new int[len + 1];
        for (int i = 0; i < len; i++) {
            C[i + 1] = cards[i]; 
        }
        
        boolean[] visited = new boolean[len + 1];
        for (int i = 1; i <= len; i++) {
            int cnt = 0;
            int idx = i;
            while (!visited[idx]) {
                visited[idx] = true;
                cnt++;
                idx = C[idx];
            }
            if (cnt > 0) {
                pq.add(cnt);
            }
        }
        
        if (pq.size() <= 1) {
            return 0;
        }

        return pq.poll() * pq.poll();
    }
}