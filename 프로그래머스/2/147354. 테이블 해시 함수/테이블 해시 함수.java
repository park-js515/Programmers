import java.util.Arrays;

class Solution {
    private int getS(int[] arr, int idx) {
        idx++;
        int ret = 0;
        for (int i: arr) {
            ret += i % idx;
        }
        
        return ret;
    }
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        final int C = col - 1;
        final int RB = row_begin - 1;
        final int RE = row_end - 1;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[C] != o2[C]) {
                return o1[C] - o2[C];
            }
            return o2[0] - o1[0];
        });
        
        int len = data.length;
        int[] sArr = new int[len];
        for (int i = RB; i <= RE; i++) {
            sArr[i] = getS(data[i], i);
        }
        
        int answer = sArr[RB];
        for (int i = RB + 1; i <= RE; i++) {
            answer = answer ^ sArr[i];
        }
        
        return answer;
    }
}