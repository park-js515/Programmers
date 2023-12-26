// floyd warshall
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 10000001;
                }
            }
        }
        for (int[] fare: fares) {
            matrix[fare[0]][fare[1]] = fare[2];
            matrix[fare[1]][fare[0]] = fare[2];
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            int sum = matrix[s][i] + matrix[i][a] + matrix[i][b];
            answer = Math.min(answer, sum);
        }
        answer = Math.min(answer, matrix[s][a] + matrix[s][b]);
        
        return answer;
    }
}