class Solution {
    private static int[] answer = new int[2];
    private static int[][] ARR;
    private static void dfs(int rs, int re, int cs, int ce) {
        if (rs == re || cs == ce) return;
        int num = ARR[rs][cs];
        boolean compressible = true;
        point: for (int i = rs; i < re; i++) {
            for (int j = cs; j < ce; j++) {
                if (num != ARR[i][j]) {
                    compressible = false;
                    break point;
                }
            }
        }
        if (compressible) {
            answer[num]++;
        } else {
            dfs(rs, (rs + re) / 2, cs, (cs + ce) / 2);
            dfs(rs, (rs + re) / 2, (cs + ce) / 2, ce);
            dfs((rs + re) / 2, re, cs, (cs + ce) / 2);
            dfs((rs + re) / 2, re, (cs + ce) / 2, ce);
        }
        
    }
    public int[] solution(int[][] arr) {
        ARR = arr;
        int len = arr.length;
        dfs( 0, len, 0, len);
        return answer;
    }
}