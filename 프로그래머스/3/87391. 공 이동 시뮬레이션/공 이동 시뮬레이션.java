import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        int[][] d = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(queries));
        Collections.reverse(list);
        long x1, x2, y1, y2;
        x1 = x2 = x;
        y1 = y2 = y;
        
        long answer = 0;
        for (int[] q: list) {
            int a = q[0], b = q[1];
            int dr = d[a][0] * b;
            int dc = d[a][1] * b;
            
            if (dr != 0) {
                if (dr > 0) { // 위쪽에서 온 경우
                    if (x2 == n - 1) {
                        x1 = Math.max(x1 - dr, 0);
                    } else {
                        if (x2 - dr < 0) {
                            return 0;
                        } else {
                            x1 = Math.max(x1 - dr, 0);
                            x2 = Math.max(x2 - dr, 0);
                        }
                    }
                } else { // 아래에서 온 경우
                    if (x1 == 0) {
                        x2 = Math.min(x2 - dr, n - 1);
                    } else {
                        if (x1 - dr > n - 1) {
                            return 0;
                        } else {
                            x1 = Math.min(x1 - dr, n - 1);
                            x2 = Math.min(x2 - dr, n - 1);
                        }
                    }
                }
            } else {
                if (dc > 0) { // 좌측에서 온 경우
                    if (y2 == m - 1) {
                        y1 = Math.max(y1 - dc, 0);
                    } else {
                        if (y2 - dc < 0) {
                            return 0;
                        } else {
                            y1 = Math.max(y1 - dc, 0);
                            y2 = Math.max(y2 - dc, 0);
                        }
                    }
                } else { // 우측에서 온 경우
                    if (y1 == 0) {
                        y2 = Math.min(y2 - dc, m - 1);
                    } else {
                        if (y1 - dc > m - 1) {
                            return 0;
                        } else {
                            y1 = Math.min(y1 - dc, m - 1);
                            y2 = Math.min(y2 - dc, m - 1);
                        }
                    }
                }
            }
        }
        
        answer = (x2 - x1 + 1) * (y2 - y1 + 1);
        return answer;
    }
}