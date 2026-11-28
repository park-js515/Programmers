class Solution {
    public int[] solution(int[] num_list, int n) {
        n--;
        int s = num_list.length - n;
        int[] answer = new int[s];
        for (int i = 0; i < s; i++) {
            answer[i] = num_list[n++];
        }
        
        return answer;
    }
}