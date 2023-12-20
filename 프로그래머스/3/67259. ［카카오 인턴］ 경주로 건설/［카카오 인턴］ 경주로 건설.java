import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int dijkstra(int rows, int cols, int[][] board) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][][] visited = new int[rows][cols][4];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < 4; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;   
                }
            }
        }
        
        board[0][0] = 1; // 불필요한 방문 제거
        if (board[1][0] != 1) {
            pq.add(new Node(1, 0, 1, 100));
        }
        if (board[0][1] != 1) {
            pq.add(new Node(0, 1, 3, 100));
        }
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.row][node.col][node.direction] <= node.cost) continue;
            if (node.row == rows- 1 && node.col == cols - 1) {
                return node.cost;
            }
            visited[node.row][node.col][node.direction] = node.cost;
            
            for (int i = 0; i < 4; i++) {
                if (i == node.direction) continue;
                if (visited[node.row][node.col][i] > visited[node.row][node.col][node.direction] + 500) {
                    pq.add(new Node(node.row, node.col, i, visited[node.row][node.col][node.direction] + 500));
                }
            }
            
            int dr = node.row + d[node.direction][0];
            int dc = node.col + d[node.direction][1];
            if (dr < 0 || dr >= rows || dc < 0 || dc >= cols || 
               board[dr][dc] == 1) continue;
            if (visited[dr][dc][node.direction] > visited[node.row][node.col][node.direction] + 100) {
                pq.add(new Node(dr, dc, node.direction, visited[node.row][node.col][node.direction] + 100));
            }
        }
        
        return -1;
    }
    public int solution(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        return dijkstra(rows, cols, board);
    }
    
    private class Node implements Comparable<Node> {
        int row, col, direction, cost;
        
        public Node(int row, int col, int direction, int cost) {
            this.row = row;
            this.col = col;
            this.direction = direction;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}