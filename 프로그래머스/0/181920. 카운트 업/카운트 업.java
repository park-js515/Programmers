
class Solution {
    public int[] solution(int start_num, int end_num) {
        int cnt = end_num - start_num + 1;
        int index = 0;
        int[] answer = new int[cnt];
        
        for (int i = 0; i < cnt; i++) {
            answer[i] = start_num++;
        }
        
        return answer;
    }
}