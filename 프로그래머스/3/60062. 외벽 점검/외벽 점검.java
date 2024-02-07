import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int answer = Integer.MAX_VALUE;
    int weakLen, distLen;
    int[] expanded;
    boolean[] visited;
    
    private void dfs(int n, int[] dist, int depth, int[] arr) {  
        if (depth == distLen) {
            for (int i = 0; i < weakLen - 1; i++) {
                int cnt = 0;
                int idx = i;
                int value = -1;
                while (idx < i + weakLen) {
                    if (value < expanded[idx]) {
                        if (cnt == distLen) {
                            break;
                        }
                        value = expanded[idx++] + arr[cnt++];
                    } else {
                        idx++;
                    }
                }
                if (idx == i + weakLen) {
                    answer = Math.min(answer, cnt);
                }
            }
            return;
        }
        
        for (int i = 0; i < distLen; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = dist[i];
                dfs(n, dist, depth + 1, arr);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int n, int[] weak, int[] dist) { 
        weakLen = weak.length;
        distLen = dist.length;
        expanded = new int[weakLen * 2];
        for (int i = 0; i < weakLen; i++) {
            expanded[i] = weak[i];
            expanded[i + weakLen] = weak[i] + n;
        }
        visited = new boolean[distLen];
        dfs(n, dist, 0, new int[distLen]);
        
        return answer != Integer.MAX_VALUE ? answer : -1;
    }
}