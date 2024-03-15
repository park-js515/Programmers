import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] data) {
        int answer = 0;
        
        Arrays.sort(data, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        for (int i = 0; i < n; i++) {
            int x1 = data[i][0], y1 = data[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = data[j][0], y2 = data[j][1];
                if (x1 == x2 || y1 == y2) {
                    continue;
                }
                
                boolean check = true;
                for (int k = i + 1; k < n; k++) {
                    int bx = Math.min(x1, x2);
                    int tx = Math.max(x1, x2);
                    int by = Math.min(y1, y2);
                    int ty = Math.max(y1, y2);
                    int kx = data[k][0], ky = data[k][1];
                    if (kx > bx && kx < tx && ky > by && ky < ty) {
                        check = false;
                        break;
                    }
                }
                
                if (check) answer++;
            }
        }
        
        return answer;
    }
}