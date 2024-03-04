import java.util.ArrayDeque;

class Solution {
    private int answer = Integer.MAX_VALUE;
    private boolean[] visited = new boolean[9];
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private int[] move(int[][] board, int r, int c, int direction) {
        int dr = r;
        int dc = c;
        
        for (int i = 0; i < 4; i++) {
            int tempDr = dr + d[direction][0];
            int tempDc = dc + d[direction][1];
            
            if (tempDr < 0 || tempDr >= 4 || tempDc < 0 || tempDc >= 4) {
                break;
            }
            dr = tempDr;
            dc = tempDc;
            if (board[dr][dc] != 0) {
                break;
            }
        }
        
        return new int[] {dr, dc};
    }
    
    private int[][] init() {
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        return arr;
    }
    
    private int[][] clone(int[][] board) {
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = board[i][j];
            }
        }
        return arr;
    }
    
    private void remove(int[][] board, int target) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = board[i][j] == target ? 0 : board[i][j];
            }
        }
    }
    
    private void dfs(int len, int[] arr, int depth, int[][] board, int r, int c) {
        if (len == depth) {
            answer = Math.min(answer, bfs(len, arr, clone(board), r, c));
            return;
        }
        
        for (int i = 1; i <= len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(len, arr, depth + 1, board, r, c);
                visited[i] = false;
            }
        }
    }
    private int bfs(int len, int[] arr, int[][] board, int r, int c) {
        int index = 0;
        int cnt = 0;
        int target = -1;
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] visited = init();
        queue.add(new int[] {r, c});
        visited[r][c] = 0;
        
        while (index < len) {
            point: while (!queue.isEmpty()) {
                int[] node = queue.poll();
                int a = node[0];
                int b = node[1];
                int cost = visited[a][b];
                
                if (board[a][b] == arr[index] && target == -1) {
                    cnt += cost + 1;
                    target = arr[index];
                    visited = init();
                    visited[a][b] = 0;
                    queue.clear();
                    queue.add(new int[] {a, b});
                    break point;
                }
                
                for (int i = 0; i < 4; i++) {
                    int dr = a + d[i][0];
                    int dc = b + d[i][1];
                    
                    if (dr < 0 || dr >= 4 || dc < 0 || dc >= 4) {
                        continue;
                    }
                    
                    if (visited[dr][dc] > cost + 1) {
                        if (board[dr][dc] == target) {
                            cnt += cost + 2;
                            remove(board, target);
                            target = -1;
                            visited = init();
                            visited[dr][dc] = 0;
                            queue.clear();
                            queue.add(new int[] {dr, dc});
                            index++;
                            break point;
                        } else {
                            visited[dr][dc] = cost + 1;
                            queue.add(new int[] {dr, dc});
                        }
                    }
                }
                
                for (int i = 0; i < 4; i++) {
                    int[] dd = move(board, a, b, i);
                    int dr = dd[0];
                    int dc = dd[1];
                    
                    if (visited[dr][dc] > cost + 1) {
                        if (board[dr][dc] == target) {
                            cnt += cost + 2;
                            remove(board, target);
                            target = -1;
                            visited = init();
                            visited[dr][dc] = 0;
                            queue.clear();
                            queue.add(new int[] {dr, dc});
                            index++;
                            break point;
                        } else {
                            visited[dr][dc] = cost + 1;
                            queue.add(new int[] {dr, dc});
                        }
                    }
                }
            }
        }
        
        return cnt;
    }
    
    
    public int solution(int[][] board, int r, int c) {
        int len = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                len = Math.max(len, board[i][j]);
            }
        }
        
        dfs(len, new int[len], 0, board, r, c);
        return answer;
    }
}