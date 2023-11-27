import java.util.HashMap;

class Solution {
    private static int answer = 0;
    private static void dfs(int n, int[] lenList, int depth, int start, int prefixed) {
        for (int i = start; i < n; i++) {
            if (depth == 0) {
                prefixed = lenList[i];
                answer += prefixed;
                dfs(n, lenList, depth + 1, i + 1, prefixed);
            } else {
                answer += prefixed * lenList[i];
                dfs(n, lenList, depth + 1, i + 1, prefixed * lenList[i]);
            }        
        }
    }
    
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothItem: clothes) {
            map.put(clothItem[1], map.getOrDefault(clothItem[1], 0) + 1);
        }
        int[] lenList = new int[map.size()];
        int idx = 0;
        for (String key: map.keySet()) {
            lenList[idx++] = map.get(key);
        }
        
        dfs(lenList.length, lenList, 0, 0, 0);
        return answer;
    }
}