import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] r = new boolean[n + 2];
        boolean[] losted = new boolean[n + 2];
        for (int i : reserve) {
            r[i] = true;
        }
        for (int i : lost) {
            losted[i] = true;
        }
        Arrays.sort(lost);
        
        
        int answer = n - lost.length;
        for (int i : lost) {
            if (losted[i] && r[i]) {
                losted[i] = false;
                r[i] = false;
                answer++;
            }
        }
        
        for (int i : lost) {
            if (!losted[i]) {
                continue;
            }
            losted[i] = false;
            
            if (r[i - 1]) {
                r[i - 1] = false;
                answer++;
                continue;
            }
            if (r[i + 1]) {
                r[i + 1] = false;
                answer++;
            }
        }
        
        return answer;
    }
}