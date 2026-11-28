class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        int n = arr.length;
        int s = -1, e = -1;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 2) {
                s = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                e = i;
                break;
            }
        }
        
        if (s == -1) {
            return answer;
        }
        
        answer = new int[e - s + 1];
        int idx = 0;
        for (int i = s; i <= e; i++) {
            answer[idx++] = arr[i];
        }
        
        return answer;
    }
}