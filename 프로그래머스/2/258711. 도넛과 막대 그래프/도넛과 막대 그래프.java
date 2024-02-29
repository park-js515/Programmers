import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
    private boolean[] visited = new boolean[1_000_001];
    private int[] answer = new int[4];
    
    private void bfs(HashMap<Integer, ArrayList<Integer>> map, int index) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(index);
        int cnt = 0;
        visited[index] = true; 
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int i: map.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                } else {
                    cnt++;
                }
            }
        }
        
        if (cnt == 1) {
            answer[1]++;
        } else if (cnt == 0) {
            answer[2]++;
        } else {
            answer[3]++;
        }
    }
    
    public int[] solution(int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(a).add(b);
            count.put(a, count.getOrDefault(a, 0));
            count.put(b, count.getOrDefault(b, 0) + 1);
        }
        
        int point = -1;
        for (int i: count.keySet()) {
            if (count.get(i) == 0 && map.get(i).size() >= 2) {
                point = i;
                break;
            }
        }
        
        answer[0] = point;
        for (int i: map.get(point)) {
            bfs(map, i);
        }
        
        return answer;
    }
}