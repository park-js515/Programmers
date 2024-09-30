import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                pq.add(new Node(rank[i], i));
            }
        }
        
        int answer = 0;
        answer += pq.poll().i * 10000;
        answer += pq.poll().i * 100;
        answer += pq.poll().i;
        
        return answer;
    }
    
    private class Node implements Comparable<Node> {
        int r, i;
        
        public Node(int r, int i) {
            this.r = r;
            this.i = i;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.r - o.r;
        }
    }
}