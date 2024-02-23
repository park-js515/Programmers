class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int alpMin = Integer.MAX_VALUE;
        int copMin = Integer.MAX_VALUE;
        int alpMax = 0;
        int copMax = 0;
        int[][] base = {{0, 0, 1, 0, 1}, {0, 0, 0, 1, 1}};
        for (int[] p: problems) {
            alpMin = Math.min(alpMin, p[0]);
            copMin = Math.min(copMin, p[1]);
            alpMax = Math.max(alpMax, p[0]);
            copMax = Math.max(copMax, p[1]);
        }
        alpMin = Math.min(alpMin, alp);
        copMin = Math.min(copMax, cop);
        alpMax = Math.max(alpMax, alp);
        copMax = Math.max(copMax, cop);
        
        if (alpMax == alp && copMax == cop) {
            return answer;
        }
        
        int[][] field = new int[alpMax + 1][copMax + 1];
        for (int i = 0; i < alpMax + 1; i++) {
            for (int j = 0; j < copMax + 1; j++) {
                field[i][j] = 10_000_000;
            }
        }
        
        for (int i = alpMin; i <= alp; i++) {
            for (int j = copMin; j <= cop; j++) {
                field[i][j] = 0;
            }
        }
        
        for (int i = alpMin; i < alpMax + 1; i++) {
            for (int j = copMin; j < copMax + 1; j++) {
                for (int[] p: base) {
                    if (i >= p[0] && j >= p[1]) {
                        int dr = Math.min(i + p[2], alpMax);
                        int dc = Math.min(j + p[3], copMax);
                        field[dr][dc] = Math.min(field[dr][dc], field[i][j] + p[4]);
                    }
                }
                
                for (int[] p: problems) {
                    if (i >= p[0] && j >= p[1]) {
                        int dr = Math.min(i + p[2], alpMax);
                        int dc = Math.min(j + p[3], copMax);
                        field[dr][dc] = Math.min(field[dr][dc], field[i][j] + p[4]);
                    }
                }
            }
        }

        answer = field[alpMax][copMax];
        return answer;
    }
}