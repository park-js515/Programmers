import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        // return Arrays.stream(num_list).sorted().limit(5).toArray();
        Arrays.sort(num_list);
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            answer[i] = num_list[i];
        }
        
        return answer;
    }
}