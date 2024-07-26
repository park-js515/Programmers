class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        answer[0] = -1;
        
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            
            if (answer[0] < val) {
                answer[0] = val;
                answer[1] = i;
            }
        }
        
        return answer;
    }
}