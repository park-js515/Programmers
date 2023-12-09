import java.util.Arrays;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        long[] prefixed = new long[1 + (len * 2)];
        for (int i = 1; i <= len; i++) {
            prefixed[i] = prefixed[i - 1] + queue1[i - 1];
        }
        for (int i = 1; i <= len; i++) {
            prefixed[len + i] = prefixed[len + i - 1] + queue2[i - 1];
        }
        if (prefixed[len] == prefixed[2 * len] - prefixed[len]) {
            return 0;
        }
        
        int answer = -1, temp = 0;
        int p1 = 0, p2 = len;
        while (p2 <= len * 2) {
            long val1 = prefixed[p2] - prefixed[p1];
            long val2 = prefixed[2 * len] - val1;
            
            if (val1 > val2) {
                p1++;
                temp++;
            } else if (val1 < val2) {
                p2++;
                temp++;
            } else {
                answer = temp;
                break;
            }
        }
        
        return answer;
    }
}