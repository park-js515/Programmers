import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int len = answers.length;
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] pLen = {5, 8, 10};
        ArrayList<Integer> list = new ArrayList<>();
        
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int temp = 0;
            for (int j = 0; j < len; j++) {
                temp += answers[j] == patterns[i][j % pLen[i]] ? 1: 0;
            }
            if (temp > sum) {
                sum = temp;
                list.clear();
                list.add(i + 1);
            } else if (temp == sum) {
                list.add(i + 1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}