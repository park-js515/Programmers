class Solution {
    public int[] solution(int e, int[] starts) {
        int[] arr = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                arr[j]++;
            }
        }
        
        int[] maxArr = new int[e + 1];
        int max = 0;
        int index = -1;
        for (int i = e; i >= 1; i--) {
            if (max <= arr[i]) {
                index = i;
                max = arr[i];
            }
            maxArr[i] = index;
        }
        
        int len = starts.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = maxArr[starts[i]];
        }
        
        return answer;
    }
}