import java.util.HashMap;

class Solution {
    private int[] answer;
    private boolean[] visited;
    private int max = 0;
    
    private void dfs(int n, int len, int depth, int start, int[][] dice) {
        if (depth == len) {
            int index1 = 0, index2 = 0;
            HashMap<Integer, Integer>[] mapA = new HashMap[len];
            HashMap<Integer, Integer>[] mapB = new HashMap[len];
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    mapA[index1] = new HashMap<>();
                    for (int j: dice[i]) {
                        mapA[index1].put(j, mapA[index1].getOrDefault(j, 0) + 1);
                    }
                    index1++;
                } else {
                    mapB[index2] = new HashMap<>();
                    for (int j: dice[i]) {
                        mapB[index2].put(j, mapB[index2].getOrDefault(j, 0) + 1);
                    }
                    index2++;
                }
            }
            HashMap<Integer, Integer> map1 = mapA[0];
            HashMap<Integer, Integer> map2 = mapB[0];
            HashMap<Integer, Integer> map3 = new HashMap<>();
            HashMap<Integer, Integer> map4 = new HashMap<>();
            for (int i = 1; i < len; i++) {
                for (int key1: map1.keySet()) {
                    for (int key2: mapA[i].keySet()) {
                        int key = key1 + key2;
                        int value = map1.get(key1) * mapA[i].get(key2);
                        map3.put(key, map3.getOrDefault(key, 0) + value);
                    }
                }
                for (int key1: map2.keySet()) {
                    for (int key2: mapB[i].keySet()) {
                        int key = key1 + key2;
                        int value = map2.get(key1) * mapB[i].get(key2);
                        map4.put(key, map4.getOrDefault(key, 0) + value);
                    }
                }
                map1 = new HashMap<>(map3);
                map2 = new HashMap<>(map4);
                map3.clear();
                map4.clear();
            }
            
            int tempMax = 0;
            for (int key1: map1.keySet()) {
                for (int key2: map2.keySet()) {
                    if (key1 > key2) {
                        tempMax += map1.get(key1) * map2.get(key2);
                    }
                }
            }
            
            if (tempMax > max) {
                max = tempMax;
                int index = 0;
                for (int i = 0; i < n; i++) {
                    if (visited[i]) {
                        answer[index++] = i + 1;
                    }
                }
            }
            
            return;
        }
        
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(n, len, depth + 1, i, dice);
                visited[i] = false;
            }
        }
    }
    
    public int[] solution(int[][] dice) {
        int n = dice.length;
        int len = n / 2;
        answer = new int[len];
        visited = new boolean[n];
        
        dfs(n, len, 0, 0, dice);
        
        return answer;
    }
}