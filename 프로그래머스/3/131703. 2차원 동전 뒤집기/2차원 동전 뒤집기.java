import java.util.ArrayList;

class Solution {
    private int rev(int n) {
        return n == 0 ? 1 : 0;
    }
    public int solution(int[][] beginning, int[][] target) {
        int n = beginning.length;
        int m = beginning[0].length;
        int[][] field1 = beginning;
        int[][] field2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field2[i][j] = field1[i][j];
            }
        }
        
        int answer1 = 0, answer2 = 0;
        ArrayList<Integer> same = new ArrayList<>();
        ArrayList<Integer> other = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (field1[i][0] == target[i][0]) {
                same.add(i);
            } else {
                other.add(i);
            }
        }
        
        answer1 += other.size();
        for (int i: other) {
            for (int j = 0; j < m; j++) {
                field1[i][j] = rev(field1[i][j]);
            }
        }
        
        answer2 += same.size();
        for (int i: same) {
            for (int j = 0; j < m; j++) {
                field2[i][j] = rev(field2[i][j]);
            }
        }
        
        for (int j = 0; j < m; j++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (field1[i][j] != target[i][j]) {
                    cnt++;
                }
            }
            if (cnt == n) {
                answer1++;
            } else if (cnt != 0) {
                answer1 = -1;
                break;
            }
        }
        for (int j = 0; j < m; j++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (field2[i][j] != target[i][j]) {
                    cnt++;
                }
            }
            if (cnt == n) {
                answer2++;
            } else if (cnt != 0) {
                answer2 = -1;
                break;
            }
        }
        
        if (answer1 == -1 || answer2 == -1) {
            return Math.max(answer1, answer2);
        }
        return Math.min(answer1, answer2);
    }
}