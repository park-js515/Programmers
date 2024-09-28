import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        boolean[] visited = new boolean[100_001];
        int cnt = 0;
        int index = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (cnt == k) break;
            if (!visited[arr[i]]) {
                visited[arr[i]] = true;
                cnt++;
                answer[index++] = arr[i];
            }
        }
        
        return answer;
    }
}