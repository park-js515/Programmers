import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] c = new int[3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < answers.length; j++) {
                int answer = answers[j];
                c[i] += patterns[i][j % patterns[i].length] == answer ? 1 : 0;
            }
        }
        
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, c[i]);
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (c[i] == max) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}