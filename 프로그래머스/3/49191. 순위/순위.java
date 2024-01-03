import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] matrix = new int[n + 1][n + 1];
        ArrayList<Integer>[] up = new ArrayList[n + 1];
        ArrayList<Integer>[] down = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            up[i] = new ArrayList<>();
            down[i] = new ArrayList<>();
        }
        for (int[] result: results) {
            up[result[1]].add(result[0]);
            down[result[0]].add(result[1]);
        }
        
        for (int i = 1; i <= n; i++) {
            ArrayDeque<Integer> upQueue = new ArrayDeque<>();
            ArrayDeque<Integer> downQueue = new ArrayDeque<>();
            upQueue.add(i);
            while (!upQueue.isEmpty()) {
                int now = upQueue.poll();
                for (int j: up[now]) {
                    if (matrix[i][j] == 0) {
                        matrix[i][j] = 1;
                        upQueue.add(j);
                    }
                }
            }
            downQueue.add(i);
            while (!downQueue.isEmpty()) {
                int now = downQueue.poll();
                for (int j: down[now]) {
                    if (matrix[i][j] == 0) {
                        matrix[i][j] = 1;
                        downQueue.add(j);
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += matrix[i][j];
            }
            if (sum == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}