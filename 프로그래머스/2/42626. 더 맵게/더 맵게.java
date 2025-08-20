import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        
        int answer = 0;
        boolean flag = false;
        while (pq.size() >= 2) {
            int a = pq.poll();
            if (a >= K) {
                flag = true;
                break;
            }
            
            int b = pq.poll();
            int k = a + b * 2;
            pq.add(k);
            answer++;
        }
        
        if (pq.peek() >= K) {
            flag = true;
        }
        
        return flag ? answer : -1;
    }
}