class Solution {
    public int solution(int[] a) {
        int len = a.length;
        int[] arr1 = new int[len], arr2 = new int[len];
        arr1[0] = a[0];
        arr2[len - 1] = a[len - 1];
        for (int i = 1; i < len; i++) {
            arr1[i] = Math.min(arr1[i - 1], a[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            arr2[i] = Math.min(arr2[i + 1], a[i]);
        }
        
        int answer = 0;
        for (int i = 0; i < len; i++) {
            int cnt = 0;
            if (i - 1 >= 0 && arr1[i - 1] < a[i]) {
                cnt++;
            }
            if (i + 1 < len && arr2[i + 1] < a[i]) {
                cnt++;
            }
            if (cnt <= 1) {
                answer++;
            }
        }
        
        return answer;
    }
}