import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        for (int work: works) {
            pq.add(work);
        }
        
        while (n > 0) {
            n--;
            int work = pq.poll() - 1;
            pq.add(work);
        }

        long answer = 0;
        for (int work: pq) {
            if (work > 0) {
                answer += work * work;
            }
        }

        return answer;
    }
}