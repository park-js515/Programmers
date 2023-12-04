import java.util.Arrays;

class Solution {
    private static int[] grp;
    private static int find(int a) {
        if (grp[a] == a) {
            return a;
        }
        
        grp[a] = find(grp[a]);
        return grp[a];
    }
    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        grp[y] = x;
    }
    
    public int solution(int n, int[][] costs) {
        grp = new int[n];
        for (int i = 1; i < n; i++) {
            grp[i] = i;
        }
        int len = costs.length;
        Edge[] Edges = new Edge[len];
        for (int i = 0; i < len; i++) {
            Edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
        }
        Arrays.sort(Edges);
        int links = 0;
        int linkSum = 0;
        for (Edge edge: Edges) {
            if (find(edge.begin) != find(edge.end)) {
                union(edge.begin, edge.end);
                links++;
                linkSum += edge.cost;
                if (links == n - 1) break;
            }
        }
        
        return linkSum;
    }
    
    private static class Edge implements Comparable<Edge> {
        int begin, end, cost;
        
        Edge(int begin, int end, int cost) {
            this.begin = begin;
            this.end = end;
            this.cost = cost;
        }
        
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}