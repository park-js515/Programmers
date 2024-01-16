import java.util.ArrayList;

class Solution {
    public int[] solution(long begin, long end) {
        int len = (int) (end - begin + 1);
        int[] answer = new int[len];
        int M = 10_000_000;
        int index = 0;
        for (int i = (int) begin; i <= (int) end; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    list.add(j);
                    list.add(i / j);
                }
            }
            for (int j: list) {
                if (j != i && j <= M) {
                    answer[index] = Math.max(answer[index], j);
                }
            }
            index++;
        }
        
        return answer;
    }
}