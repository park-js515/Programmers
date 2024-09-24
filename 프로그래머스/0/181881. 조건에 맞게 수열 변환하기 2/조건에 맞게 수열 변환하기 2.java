import java.util.*;

class Solution {
    private int len;
    
    private int[] copy(int[] arr) {
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            ret[i] = arr[i];
        }
        
        return ret;
    }
    
    private boolean eq(int[] arr1, int[] arr2) {
        boolean result = true;
        for (int i = 0; i < len; i++) {
            if (arr1[i] != arr2[i]) {
                result = false;
                break;
            }
        }
        
        return result;
    }
    
    public int solution(int[] arr) {
        this.len = arr.length;
        int[] before = copy(arr);
        
        int answer = 0;
        while (true) {
            answer++;
            for (int i = 0; i < len; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] = arr[i] / 2;
                } else if (arr[i] < 50 && arr[i] % 2 == 1) {
                    arr[i] = arr[i] * 2 + 1;
                }
            }
            
            if (eq(before, arr)) {
                break;
            }
            
            before = copy(arr);
        }
        
        return answer - 1;
    }
}