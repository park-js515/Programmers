import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] sumTriangle = new int[len][];
        for (int i = 0; i < len; i++) {
            sumTriangle[i] = new int[i + 1];
        }
        
        sumTriangle[0][0] = triangle[0][0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j > 0) {
                    sumTriangle[i][j] = Math.max(sumTriangle[i][j], sumTriangle[i - 1][j - 1] + triangle[i][j]);
                }
                if (j < i) {
                    sumTriangle[i][j] = Math.max(sumTriangle[i][j], sumTriangle[i - 1][j] + triangle[i][j]);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < len; i++) {
            answer = Math.max(answer, sumTriangle[len - 1][i]);
        }
        
        return answer;
    }
}