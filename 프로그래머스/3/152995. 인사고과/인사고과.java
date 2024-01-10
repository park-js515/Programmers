import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        int[] target = scores[0];
        Arrays.sort(scores, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            });
        int answer = 1, maxScore = 0, targetSum = target[0] + target[1];

        for (int[] score : scores) {
            if (score[1] < maxScore) {
                if (score.equals(target))
                    return -1;
            } else {
                maxScore = Math.max(maxScore, score[1]);
                if (score[0] + score[1] > targetSum)
                    answer++;
            }
        }
        
        return answer;
    }
}