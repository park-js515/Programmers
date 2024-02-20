import java.util.PriorityQueue;

class Solution {
    private int[][][] field;
    
    private int dijkstra(int n, int[][] board) {
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0, 1, 0));
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int r1 = node.r1, c1 = node.c1, r2 = node.r2, c2 = node.c2, cost = node.cost;
            int t = r1 == r2 ? 0 : 1;
            if (cost < field[r1][c1][t] || cost < field[r2][c2][t]) {
                field[r1][c1][t] = Math.min(field[r1][c1][t], cost);
                field[r2][c2][t] = Math.min(field[r2][c2][t], cost);
            } else {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int dr1 = r1 + d[i][0];
                int dc1 = c1 + d[i][1];
                int dr2 = r2 + d[i][0];
                int dc2 = c2 + d[i][1];
                if (dr1 < 0 || dr1 >= n || dc1 < 0 || dc1 >= n ||
                   dr2 < 0 || dr2 >= n || dc2 < 0 || dc2 >= n ||
                   board[dr1][dc1] == 1 || board[dr2][dc2] == 1) {
                    continue;
                }
                if (cost + 1 < field[dr1][dc1][t] || cost + 1 < field[dr2][dc2][t]) {
                    pq.add(new Node(dr1, dc1, dr2, dc2, cost + 1));
                }
            }
            
            int rev = 1 - t;
            if (r1 == r2) {
                if ((r1 - 1 >= 0) && board[r1 - 1][c2] == 0 && board[r1 - 1][c1] == 0 && (cost + 1 < field[r1][c1][rev] || cost + 1 < field[r1 - 1][c1][rev])) {
                    pq.add(new Node(r1, c1, r1 - 1, c1, cost + 1));
                }
                if ((r1 + 1 < n) && board[r1 + 1][c2] == 0 && board[r1 + 1][c1] == 0 && (cost + 1 < field[r1][c1][rev] || cost + 1 < field[r1 + 1][c1][rev])) {
                    pq.add(new Node(r1, c1, r1 + 1, c1, cost + 1));
                }
                if ((r2 - 1 >= 0) && board[r2 - 1][c1] == 0 && board[r2 - 1][c2] == 0 && (cost + 1 < field[r2][c2][rev] || cost + 1 < field[r2 - 1][c2][rev])) {
                    pq.add(new Node(r2, c2, r2 - 1, c2, cost + 1));
                }
                if ((r2 + 1 < n) && board[r2 + 1][c1] == 0 && board[r2 + 1][c2] == 0 && (cost + 1 < field[r2][c2][rev] || cost + 1 < field[r2 + 1][c2][rev])) {
                    pq.add(new Node(r2, c2, r2 + 1, c2, cost + 1));
                }
                
            } else {
                if ((c1 - 1 >= 0) && board[r2][c1 - 1] == 0 && board[r1][c1 - 1] == 0 && (cost + 1 < field[r1][c1][rev] || cost + 1 < field[r1][c1 - 1][rev])) {
                    pq.add(new Node(r1, c1, r1, c1 - 1, cost + 1));
                }
                if ((c1 + 1 < n) && board[r2][c1 + 1] == 0 && board[r1][c1 + 1] == 0 && (cost + 1 < field[r1][c1][rev] || cost + 1 < field[r1][c1 + 1][rev])) {
                    pq.add(new Node(r1, c1, r1, c1 + 1, cost + 1));
                }
                if ((c2 - 1 >= 0) && board[r1][c2 - 1] == 0 && board[r2][c2 - 1] == 0 && (cost + 1 < field[r2][c2][rev] || cost + 1 < field[r2][c2 - 1][rev])) {
                    pq.add(new Node(r2, c2, r2, c2 - 1, cost + 1));
                }
                if ((c2 + 1 < n) && board[r1][c2 + 1] == 0 && board[r2][c2 + 1] == 0 && (cost + 1 < field[r2][c2][rev] || cost + 1 < field[r2][c2 + 1][rev])) {
                    pq.add(new Node(r2, c2, r2, c2 + 1, cost + 1));
                }
            }
        }
        
        return Math.min(field[n - 1][n - 1][0], field[n - 1][n - 1][1]);
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        field = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    field[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        int answer = dijkstra(n, board);
        return answer;
    }
    
    private class Node implements Comparable<Node> {
        int r1, r2, c1, c2, cost;
        
        public Node(int r1, int c1, int r2, int c2, int cost) {
            this.r1 = r1;
            this.r2 = r2;
            this.c1 = c1;
            this.c2 = c2;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}