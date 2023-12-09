class Solution {
    public int[] solution(int n) {
        int[][] d = {{1, 0}, {0, 1}, {-1, -1}};
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] arr = new int[n][n];
        
        int r = 0;
        int c = 0;
        int idx = 1;
        int direction = 0;
        arr[0][0] = 1;
        while (true) {
            int dr = r + d[direction][0];
            int dc = c + d[direction][1];
            if (dr < 0 || dc < 0 || dr >= n || dc >= n || dr < dc || arr[dr][dc] != 0) {
                dr = r + d[(direction + 1) % 3][0];
                dc = c + d[(direction + 1) % 3][1];
                if (dr < 0 || dc < 0 || dr >= n || dc >= n || dr < dc || arr[dr][dc] != 0) {
                    break;
                } else {
                    r = dr;
                    c = dc;
                    arr[r][c] = ++idx;
                    direction = (direction + 1) % 3;
                }
            } else {
                r = dr;
                c = dc;
                arr[r][c] = ++idx;
            }
        }
        
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}