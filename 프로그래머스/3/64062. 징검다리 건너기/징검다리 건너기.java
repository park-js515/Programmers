import java.util.Arrays;

class Solution {
    private static boolean isPossible(int[] subtracted, int k) {
        int cnt = 0;
        for (int num: subtracted) {
            if (num <= 0) {
                if(++cnt >= k) {
                    return false;
                }
            } else {
                cnt = 0;
            }
        }
        
        return true;
    }
    
    public int solution(int[] stones, int k) {
        int len = stones.length;
        int left = 1, right = 0;
        for (int stone: stones) {
            right = Math.max(right, stone);
        }
        
        while (left < right) {
            int mid = (left + right) / 2;
            int[] subtracted = new int[len];
            for (int i = 0; i < len; i++) {
                stones[i] -= mid;
            }
            
            if (isPossible(stones, k)) {
                left = mid + 1;
            } else {
                right = mid;
            }
            
            for (int i = 0; i < len; i++) {
                stones[i] += mid;
            }
        }
        
        return left;
    }
}