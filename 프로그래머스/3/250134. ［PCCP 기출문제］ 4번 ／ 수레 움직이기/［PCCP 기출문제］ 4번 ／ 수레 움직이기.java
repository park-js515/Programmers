class Solution {
    private int n, m;
    private int rtr, rtc, btr, btc;
    private boolean[][] vr, vb;
    
    private int[][] copy(int[][] arr) {
        int[][] ret = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret[i][j] = arr[i][j];
            }
        }
        
        return ret;
    }
    
    private int answer = Integer.MAX_VALUE;
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void dfs(int depth, int[][] maze, int rr, int rc, int br, int bc) {        
        if (depth >= answer) {
            return;
        }
        
        boolean findRed, findBlue;
        findRed = findBlue = false;
        if (rr == rtr && rc == rtc) {
            findRed = true;
        }
        if (br == btr && bc == btc) {
            findBlue = true;
        }
        if (findRed && findBlue) {
            answer = depth;
            return;
        }
        
        if (!findRed && findBlue) {
            for (int i = 0; i < 4; i++) {
                int dr = rr + d[i][0];
                int dc = rc + d[i][1];
                
                if (dr < 0 || dr >= n || dc < 0 || dc >= m || 
                   maze[dr][dc] != 0 || vr[dr][dc]) {
                    continue;
                }
                
                vr[dr][dc] = true;
                int[][] copyed = copy(maze);
                copyed[dr][dc] = 1;
                copyed[rr][rc] = 0;
                dfs(depth + 1, copyed, dr, dc, br, bc);
                vr[dr][dc] = false;
            }
        }
        if (findRed && !findBlue) {
            for (int i = 0; i < 4; i++) {
                int dr = br + d[i][0];
                int dc = bc + d[i][1];
                
                if (dr < 0 || dr >= n || dc < 0 || dc >= m || 
                    maze[dr][dc] != 0 || vb[dr][dc]) {
                    continue;
                }
                
                vb[dr][dc] = true;
                int[][] copyed = copy(maze);
                copyed[dr][dc] = 2;
                copyed[br][bc] = 0;
                dfs(depth + 1, copyed, rr, rc, dr, dc);
                vb[dr][dc] = false;
            }
        }
        if (!findRed && !findBlue) {
            for (int i = 0; i < 4; i++) {
                int dr1 = rr + d[i][0];
                int dc1 = rc + d[i][1];
                
                if (dr1 < 0 || dr1 >= n || dc1 < 0 || dc1 >= m ||
                    maze[dr1][dc1] != 0 || vr[dr1][dc1]) {
                    continue;
                }
                
                vr[dr1][dc1] = true;
                int[][] copyed = copy(maze);
                copyed[dr1][dc1] = 1;
                copyed[rr][rc] = 0;
                
                for (int j = 0; j < 4; j++) {
                    int dr2 = br + d[j][0];
                    int dc2 = bc + d[j][1];
                    
                    if (dr2 < 0 || dr2 >= n || dc2 < 0 || dc2 >= m || 
                        copyed[dr2][dc2] != 0 || vb[dr2][dc2]) {
                        continue;
                    }
                    
                    vb[dr2][dc2] = true;
                    int[][] copyed2 = copy(copyed);
                    copyed2[dr2][dc2] = 2;
                    copyed2[br][bc] = 0;
                    dfs(depth  + 1, copyed2, dr1, dc1, dr2, dc2);
                    vb[dr2][dc2] = false;
                }
                vr[dr1][dc1] = false;
            }
            
            for (int i = 0; i < 4; i++) {
                int dr1 = br + d[i][0];
                int dc1 = bc + d[i][1];
                
                if (dr1 < 0 || dr1 >= n || dc1 < 0 || dc1 >= m ||
                    maze[dr1][dc1] != 0 || vb[dr1][dc1]) {
                    continue;
                }
                
                vb[dr1][dc1] = true;
                int[][] copyed = copy(maze);
                copyed[dr1][dc1] = 2;
                copyed[br][bc] = 0;
                
                for (int j = 0; j < 4; j++) {
                    int dr2 = rr + d[j][0];
                    int dc2 = rc + d[j][1];
                    
                    if (dr2 < 0 || dr2 >= n || dc2 < 0 || dc2 >= m ||
                        copyed[dr2][dc2] != 0 || vr[dr2][dc2]) {
                        continue;
                    }
                    
                    int[][] copyed2 = copy(copyed);
                    vr[dr2][dc2] = true;
                    copyed2[dr2][dc2] = 1;
                    copyed2[rr][rc] = 0;
                    dfs(depth + 1, copyed2, dr2, dc2, dr1, dc1);
                    vr[dr2][dc2] = false;
                }
                vb[dr1][dc1] = false;
            }
        }
    }
    
    public int solution(int[][] maze) {
        this.n = maze.length;
        this.m = maze[0].length;
        int rr, rc, br, bc;
        rr = rc = br = bc = 0;
        this.vr = new boolean[n][m];
        this.vb = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    rr = i;
                    rc = j;
                    vr[i][j] = true;
                } else if (maze[i][j] == 2) {
                    br = i;
                    bc = j;
                    vb[i][j] = true;
                } else if (maze[i][j] == 3) {
                    rtr = i;
                    rtc = j;
                    maze[rtr][rtc] = 0;
                } else if (maze[i][j] == 4) {
                    btr = i;
                    btc = j;
                    maze[btr][btc] = 0;
                }
            }
        }
        
        dfs(0, maze, rr, rc, br, bc);
        return answer != Integer.MAX_VALUE ? answer : 0;
    }
}