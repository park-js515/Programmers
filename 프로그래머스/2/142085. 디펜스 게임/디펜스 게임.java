import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        long sum = 0;
        int answer = enemy.length;
        int cnt = 0;
        for (int i = 0; i < enemy.length; i++) {
            int e = enemy[i];
            if (cnt < k) {
                cnt++;
                pq.add(e);
            } else {
                if (pq.peek() < e) {
                    sum += pq.poll();
                    pq.add(e);
                } else {
                    sum += e;
                }
                
                if (sum > n) {
                    answer = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}