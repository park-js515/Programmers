import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private ArrayList<Integer>[] adjList;
    private int answer = 0;
    
    private void dfs(int[] info, ArrayList<Integer> list, int sheep, int wolf) {
        answer = Math.max(answer, sheep);
        
        for (int i = 0; i < list.size(); i++) {
            int node = list.get(i);
            if (info[node] == 0) {
                ArrayList<Integer> next = new ArrayList<>(list);
                next.remove(i);
                for (int j: adjList[node]) {
                    next.add(j);
                }
                dfs(info, next, sheep + 1, wolf);
            } else if (sheep > wolf + 1) {
                ArrayList<Integer> next = new ArrayList<>(list);
                next.remove(i);
                for (int j: adjList[node]) {
                    next.add(j);
                }
                dfs(info, next, sheep, wolf + 1);
            }
        }
    }

    public int solution(int[] info, int[][] edges) {
        int len = info.length;
        adjList = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            adjList[edge[0]].add(edge[1]);
        }
        dfs(info, new ArrayList<>(Arrays.asList(0)), 0, 0);
        
        return answer;
    }
}