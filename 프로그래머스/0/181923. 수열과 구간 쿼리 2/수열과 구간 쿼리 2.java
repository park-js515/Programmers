import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int len = queries.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        
        for (int i = 0; i < len; i++) {
            int[] query = queries[i];
            int s = query[0];
            int e = query[1];
            int k = query[2];
            int res = Integer.MAX_VALUE;
            
            for (int j = s; j <= e; j++) {
                if (arr[j] > k) {
                    res = Math.min(res, arr[j]);
                }
            }
            
            if (res != Integer.MAX_VALUE) {
                result[i] = res;
            }
        }
        
        return result;
    }
}