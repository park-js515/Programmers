// 한국어가 너무 어려운 문제
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        
        int len = jobs.length;
        int total = 0;
        int now = 0;
        int idx = 0;
        int cnt = 0;
        while (cnt < len) {
            while (idx < len && jobs[idx][0] <= now) {
                pq.add(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                now = jobs[idx][0];
            } else {
                int[] task = pq.poll();
                total += now - task[0] + task[1];
                now += task[1];
                cnt++;
            }
        }
        
        return total / jobs.length;
    }
}