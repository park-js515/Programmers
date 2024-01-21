// 전역 탐색을 통해서 문제를 해결한다.
// 제거할 때 연쇄적으로 확인하는 것을 구현하는 것보다 전역탐색을 구현하는 것이 빠르다.
// 최악의 경우 20_000_000 번의 반복을 수행해야하는데 충분히 가능한 횟수라고 생각할 수 있다.
import java.util.ArrayList;

class Solution {
    private boolean[][][] field;
    private void action(int n, int x, int y, int a, int b) {
        field[x][y][a] = b == 0 ? false : true;
        for (int i = 0; i <= n; i++) { // x
            for (int j = 0; j <= n; j++) { // y
                for (int k = 0; k <= 1; k++) {
                    if (k == 0 && field[i][j][k] == true) { // 기둥
                        if (j == 0 || (i > 0 && field[i - 1][j][1] == true) ||
                           field[i][j][1] == true || field[i][j - 1][0] == true) {
                            continue;
                        } else {
                            field[x][y][a] = b == 0 ? true : false;
                            return;
                        }            
                    } else if (k == 1 && field[i][j][k] == true) { // 보
                        if (field[i][j - 1][0] == true || field[i + 1][j - 1][0] == true ||
                           (i > 0 && field[i - 1][j][1] == true && i < n && field[i + 1][j][1] == true)) {
                            continue;
                        } else {
                            field[x][y][a] = b == 0 ? true : false;
                        }
                    }
                }               
            }
        }
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        field = new boolean[n + 1][n + 1][2];
        for (int[] bf: build_frame) {
            action(n, bf[0], bf[1], bf[2], bf[3]);
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= 1; k++) {
                    if (field[i][j][k]) {
                        list.add(new int[] {i, j, k});
                    }
                }
            }
        }

        return list.stream().toArray(int[][]::new);
    }
}   