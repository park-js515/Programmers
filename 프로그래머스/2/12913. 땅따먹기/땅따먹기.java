class Solution {
    int solution(int[][] land) {
        int len = land.length;
        int[][] maxArr = new int[len][4];
        for (int i = 0; i < 4; i++) {
            maxArr[0][i] = land[0][i];
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    maxArr[i + 1][k] = Math.max(maxArr[i + 1][k], maxArr[i][j] + land[i + 1][k]);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, maxArr[len - 1][i]);
        }
        
        return answer;
    }
}