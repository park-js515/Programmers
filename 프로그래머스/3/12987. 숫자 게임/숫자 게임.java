import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        int idx1 = 0;
        int idx2 = 0;
        int answer = 0;
        
        while (idx1 < len && idx2 < len) {
            if (A[idx1] < B[idx2]) {
                idx1++;
                idx2++;
                answer++;
            } else {
                idx2++;
            }
        }
        
        return answer;
    }
}