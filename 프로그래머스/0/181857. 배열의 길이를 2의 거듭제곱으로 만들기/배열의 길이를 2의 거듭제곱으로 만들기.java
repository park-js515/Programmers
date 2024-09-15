class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        int cnt = 1;
        int k = 0;
        
        while (len > cnt) {
            k++;
            cnt <<= 1;
        }
        
        len = (int) Math.pow(2, k);
        int[] answer = new int[len];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }
        
        return answer;
    }
}