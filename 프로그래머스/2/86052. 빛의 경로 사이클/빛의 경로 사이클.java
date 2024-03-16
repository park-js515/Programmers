import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[] left = {2, 3, 1, 0};
    private int[] right = {3, 2, 0, 1};
    private int[] grp;
    private int[] cnt;
    
    private int find(int a) {
        if (grp[a] == a) {
            return a;
        }
        
        grp[a] = find(grp[a]);
        return grp[a];
    }
    
    private void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        
        grp[y] = x;
    }
    
    public int[] solution(String[] grid) {
        int r = grid.length;
        int c = grid[0].length();
        char[][] g = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                g[i][j] = grid[i].charAt(j);
            }
        }
        
        int len = 4 * r * c;
        grp = new int[len];
        cnt = new int[len];
        for (int i = 0; i < len; i++) {
            grp[i] = i;
        }
        
        for (int i = 0; i < len; i++) {
            int temp = i / 4;
            int dr = temp / c;
            int dc = temp % c;
            int direction = i % 4;
            
            int nextDr = (dr + d[direction][0] + r) % r;
            int nextDc = (dc + d[direction][1] + c) % c;
            if (g[nextDr][nextDc] == 'L') {
                direction = left[direction];
            } else if (g[nextDr][nextDc] == 'R') {
                direction = right[direction];
            }
            int target = nextDr * c * 4 + nextDc * 4 + direction;
            
            if (find(i) != find(target)) {
                union(i, target);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            cnt[find(i)]++;
        }
        for (int a: cnt) {
            if (a > 0) {
                list.add(a);
            }
        }
        Collections.sort(list);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}