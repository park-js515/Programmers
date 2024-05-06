// https://loosie.tistory.com/341
// 다익스트라를 수행하는데, trap를 고려한다. (다익스트라 + 비트마스킹)
// 시작과 끝이 모두 트랩이 작동되거나, 작동되지 않는다면 기존의 방향대로 전진하면 된다.
// 만약 두 방향이 다르다면 반대방향으로 움직이는 것을 고려한다.
// 서로 다른 두 방 사이에 직접 연결된 길이 여러 개 존재할 수도 있습니다. -> 값이 중복일 수 있으므로 Math.min을 사용한다.


import java.util.*;

class Solution {
    private int n;
    private int[][] dist;
    private int[][] visited;
    private Map<Integer, Integer> map = new HashMap<>();
    private Set<Integer> set;
    private List<Integer>[] adjList1, adjList2; // 순방향, 역방향
    
    private void init(int n, int[][] roads, int[] traps) {
        this.n = n;
        this.dist = new int[n + 1][n + 1];
        this.adjList1 = new ArrayList[n + 1];
        this.adjList2 = new ArrayList[n + 1];
        this.visited = new int[n + 1][(int) Math.pow(2, traps.length)];
        
        for (int i = 0; i < n + 1; i++) {
            adjList1[i] = new ArrayList<>();
            adjList2[i] = new ArrayList<>();
        }
    
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dist[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < (int) Math.pow(2, traps.length); j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int[] road: roads) {
            dist[road[0]][road[1]] = Math.min(dist[road[0]][road[1]], road[2]);
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j || dist[i][j] == Integer.MAX_VALUE) continue;
                adjList1[i].add(j);
                adjList2[j].add(i);
            }
        }
        
        for (int i = 0; i < traps.length; i++) {
            map.put(traps[i], 1 << i);
        }
        set = new HashSet<>(map.keySet());
    }
    
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        init(n, roads, traps);
        
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0, 0));
        
        int answer = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.idx][node.status] <= node.cost) continue;
            if (node.idx == end) {
                answer = node.cost;
                break;
            }
            visited[node.idx][node.status] = node.cost;
            
            node.status = set.contains(node.idx) ? node.status ^ map.get(node.idx) : node.status;
            boolean check1 = set.contains(node.idx) ? (node.status & map.get(node.idx)) > 0 : false;
            
            for (int child: adjList1[node.idx]) {
                boolean check2 = set.contains(child) ? (node.status & map.get(child)) > 0 : false;
                if (!(check1 ^ check2)) {
                    if (visited[child][node.status] > node.cost + dist[node.idx][child]) {
                        pq.add(new Node(child, node.cost + dist[node.idx][child], node.status));
                    }
                }
            }
            
            for (int child: adjList2[node.idx]) {
                boolean check2 = set.contains(child) ? (node.status & map.get(child)) > 0 : false;
                if (check1 ^ check2) {
                    if (visited[child][node.status] > node.cost + dist[child][node.idx]) {
                        pq.add(new Node(child, node.cost + dist[child][node.idx], node.status));
                    }
                }
            }
        }
        
        return answer;
    }
    
    private class Node implements Comparable<Node> {
        int idx, cost, status;
        
        public Node(int idx, int cost, int status) {
            this.idx = idx;
            this.cost = cost;
            this.status = status;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}