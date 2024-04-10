import java.util.Arrays;

class Solution {
    public int solution(int[] cookie) {
        int n = cookie.length;
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            int leftValue = 0;
            int rightValue = cookie[i];
            
            while (true) {
                if (leftValue < rightValue) {
                    if (--left < 0) break;
                    leftValue += cookie[left];
                } else if (leftValue > rightValue) {
                    if (++right >= n) break;
                    rightValue += cookie[right];
                } else {
                    answer = Math.max(answer, leftValue);
                    if (--left < 0) break;
                    leftValue += cookie[left];
                }   
            }
        }
        
        return answer;
    }
}