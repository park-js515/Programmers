import java.util.ArrayDeque;


class Solution {
    private int n, m;
    private char[][] storageArr;
    private boolean[][] isOuter;
    private ArrayDeque<Pos> queue = new ArrayDeque<>();
    private int answer;
    
    private void init(String[] storage) {
        n = storage.length;
        m = storage[0].length();
        
        storageArr = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                storageArr[i][j] = storage[i].charAt(j);
            }
        }
        
        isOuter = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    isOuter[i][j] = true;
                }
            }
        }
        
        answer = n * m;
    }

    private void operation(int r, int c, String request) {
        char ch = request.charAt(0);
        int len = request.length();
        
        if (storageArr[r][c] != ch) {
            return;
        }
        
        if (len == 1) {
            if (isOuter[r][c]) {
                queue.add(new Pos(r, c));
            }
        } else {
            queue.add(new Pos(r,c));
        }
    }
    
    private void bfs() {
        answer -= queue.size();
        for (Pos pos : queue) {
            storageArr[pos.r][pos.c] = ' ';
        }
        
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            int r = pos.r;
            int c = pos.c;
            
            if (isOuter[r][c]) {
                for (int i = 0; i < 4; i++) {
                    int dr = r + d[i][0];
                    int dc = c + d[i][1];
                    
                    if (dr < 0 || dr >= n || dc < 0 || dc >= m) {
                        continue;
                    }
                    
                    if (storageArr[dr][dc] == ' ' && !isOuter[dr][dc]) {
                        queue.add(new Pos(dr, dc));
                    }
                    isOuter[dr][dc] = true;
                }
            }
        }
    }
    
    
    public int solution(String[] storage, String[] requests) {
        init(storage);
        
        for (String request : requests) {
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    operation(i, j, request);
                }
            }
            
            bfs();
        }
        
        return answer;
    }
    
    private class Pos {
        int r, c;
        
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}