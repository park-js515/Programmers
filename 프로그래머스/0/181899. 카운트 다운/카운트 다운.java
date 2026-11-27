class Solution {
    public int[] solution(int start_num, int end_num) {
        int gap = start_num - end_num + 1;
        int[] answer = new int[gap];
        
        for (int i = 0; i < gap; i++) {
            answer[i] = start_num--;
        }
        
        return answer;
    }
}