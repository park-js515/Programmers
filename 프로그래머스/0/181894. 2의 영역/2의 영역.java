import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int s = -1;
        int e = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                s = i;
                break;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                e = i;
                break;
            }
        }
        
        int[] answer;
        if (s == -1) {
            answer = new int[] {-1};
        } else {
            answer = Arrays.copyOfRange(arr, s, e + 1);
        }
        
        return answer;
    }
}