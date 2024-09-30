class Solution {
    public int solution(int[][] dots) {
        int r = 0;
        int c = 0;
        
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                r = Math.max(r, Math.abs(dots[i][0] - dots[j][0]));
                c = Math.max(c, Math.abs(dots[i][1] - dots[j][1]));
            }
        }
        
        return r * c;
    }
}