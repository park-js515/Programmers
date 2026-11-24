class Solution {
    public int[] solution(int start_num, int end_num) {
        int length = end_num - start_num + 1;
        int[] answer = new int[length];
        int t = start_num;
        for (int i = 0; i < length; i++) {
            answer[i] = t++;
        }
        
        return answer;
    }
}