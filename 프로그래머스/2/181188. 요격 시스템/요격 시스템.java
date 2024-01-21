import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        
        int answer = 1;
        int s = targets[0][0], e = targets[0][1];
        for (int i = 1; i < targets.length; i++) {
            int[] target = targets[i];
            if (target[0] < e) {
                s = Math.max(s, target[0]);
                e = Math.min(e, target[1]);
            } else {
                answer++;
                s = target[0];
                e = target[1];
            }
        }
        return answer;
    }
}