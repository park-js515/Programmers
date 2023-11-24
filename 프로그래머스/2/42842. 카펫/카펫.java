class Solution {
    private static int[] getDecimal(int n) {
        boolean[] list = new boolean[n + 1];
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list[i] = true;
                list[n / i] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (list[i]) {
                cnt++;
            }
        }
        int[] ret = new int[cnt];
        int index = 0;
        for (int i = 0; i <= n; i++) {
            if (list[i]) {
                ret[index++] = i;
            }
        }
            
        return ret;
    }
    
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        int[] decimals = getDecimal(yellow);
        int len = decimals.length;
        
        for (int i = 0; i <= len / 2; i++) {
            int height = decimals[i];
            int width = decimals[len - 1 - i];
            if (brown == 4 + (height + width) * 2) {
                answer[0] = width + 2;
                answer[1] = height + 2;
                break;
            }
        }
        
        
        return answer;
    }
}