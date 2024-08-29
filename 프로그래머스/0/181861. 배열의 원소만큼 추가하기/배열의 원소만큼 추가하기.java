class Solution {
    public int[] solution(int[] arr) {
        int sum = 0;
        for (int i: arr) {
            sum += i;
        }
        
        int[] answer = new int[sum];
        int index = 0;
        for (int i: arr) {
            for (int j = 0; j < i; j++) {
                answer[index++] = i;
            }
        }
        
        return answer;
    }
}