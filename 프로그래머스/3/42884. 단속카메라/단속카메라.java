import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int start, end;
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        System.out.println(Arrays.deepToString(routes));
        start = routes[0][0];
        end = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            int[] route = routes[i];
            if (route[0] >= start && route[0] <= end) {
                start = route[0];
                end = Math.min(end, route[1]);
            } else {
                start = route[0];
                end = route[1];
                answer++;
            }
        }
        answer++;
        return answer;
    }
}