class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int cnt = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < delete_list.length; j++) {
                if (arr[i] == delete_list[j]) {
                    arr[i] = 0;
                    cnt--;
                    break;
                }
            }
        }
        
        int[] answer = new int[cnt];
        int index = 0;
        for (int i : arr) {
            if (i != 0) {
                answer[index++] = i;
            }
        }
        
        return answer;
    }
}