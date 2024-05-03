import java.util.Queue;
import java.util.PriorityQueue;

class Solution {
    private int N;
    private int[] grp;
    
    private int find(int a) {
        if (grp[a] == a) {
            return a;
        }
        
        return grp[a] = find(grp[a]);
    }
    
    private void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        
        grp[y] = x;
    }
    
    public int solution(int[][] land, int height) {
        this.N = land.length;
        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int h1 = land[i][j];
                int index = i * N + j;
                
                if (j + 1 < N) {
                    int h2 = land[i][j + 1];
                    int gap1 = Math.abs(h1 - h2);
                    int index1 = i * N + (j + 1);
                    Node node1 = new Node(index, index1, gap1 <= height ? 0 : gap1);
                    pq.add(node1);
                }
                
                if (i + 1 < N) {
                    int h3 = land[i + 1][j];
                    int gap2 = Math.abs(h1 - h3);
                    int index2 = (i + 1) * N + j;
                    Node node2 = new Node(index, index2, gap2 <= height ? 0 : gap2);
                    pq.add(node2);
                }
            }
        }
        
        this.grp = new int[N * N];
        for (int i = 0; i < N * N; i++) {
            grp[i] = i;
        }
        
        int answer = 0;
        int links = 0;
        int target = N * N - 1;
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (find(node.index1) != find(node.index2)) {
                union(node.index1, node.index2);
                answer += node.cost;
                
                if (++links == target) {
                    break;
                }
            }
        }
        
        return answer;
    }
        
    
    private class Node implements Comparable<Node> {
        int index1, index2, cost;
        
        public Node(int index1, int index2, int cost) {
            this.index1 = index1;
            this.index2 = index2;
            this.cost = cost;
        };
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}