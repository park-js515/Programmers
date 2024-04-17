// 추가적으로 제거할 수 없다면 순회를 멈춘다.
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Arrays;


class Solution {
    private final int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] board;
    private int n;
    private boolean[] visited = new boolean[201];
    private boolean[][] boardVisited = new boolean[51][51];
    private int answer = 0;
    private Queue<Block> block = new ArrayDeque<>();
    
    private void bfs(int r, int c) {
        int index = board[r][c];
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(r, c));
        boardVisited[r][c] = true;
        
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(r, c));
        
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int dr = pair.r + D[i][0];
                int dc = pair.c + D[i][1];
                
                if (dr < 0 || dr >= n || dc < 0 || dc >= n ||
                    boardVisited[dr][dc] || board[dr][dc] != index) continue;
                
                boardVisited[dr][dc] = true;
                Pair nextPair = new Pair(dr, dc);
                queue.add(nextPair);
                list.add(nextPair);
            }
        }
        
        int r1, r2, c1, c2;
        r1 = c1 = Integer.MAX_VALUE;
        r2 = c2 = 0;
        for (Pair pair: list) {
            r1 = Math.min(r1, pair.r);
            r2 = Math.max(r2, pair.r);
            c1 = Math.min(c1, pair.c);
            c2 = Math.max(c2, pair.c);
        }
        
        List<Pair> blanks = new ArrayList<>();
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                Pair blank = new Pair(i, j);
                Pair check = new Pair(i - 1, j);
                
                if (!list.contains(blank)) { 
                    if (list.contains(check)) return;
                    blanks.add(blank);
                }
            }
        }
        
        block.add(new Block(list, blanks));
    }
    
    public int solution(int[][] board) {
        this.n = board.length;
        this.board = board;
        visited[0] = true;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = board[i][j];
                if (!visited[index]) {
                    visited[index] = true;
                    bfs(i, j);
                }
            }
        }
        
        while (!block.isEmpty()) {
            int before = answer;
            int size = block.size();
            for (int s = 0; s < size; s++) {
                Block b = block.poll();
                List<Pair> list = b.list;
                List<Pair> left = b.left;
                
                boolean flag = true;  
                point: for (Pair p: left) {
                    for (int i = 0; i <= p.r; i++) {
                        if (board[i][p.c] != 0) {
                            flag = false;
                            block.add(b);
                            break point;                   
                        }
                    }
                }
                
                if (flag) {
                    answer++;
                    for (Pair p: list) {
                        board[p.r][p.c] = 0;
                    }
                }
            }
            
            if (before == answer) break;
        }
        
        return answer;
    }
    
    private static class Pair {
        int r, c;
        
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) {
                return false;
            }
            
            Pair pair = (Pair) o;
            return this.r == pair.r && this.c == pair.c;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
        
        @Override
        public String toString() {
            return "Pair<" + this.r + ", " + this.c + ">";
        }
    }
    
    private static class Block {
        List<Pair> list, left;
        
        public Block(List<Pair> list, List<Pair> left) {
            this.list = list;
            this.left = left;
        }
    }
}