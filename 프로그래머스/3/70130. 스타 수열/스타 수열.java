import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


class Solution {
    public int solution(int[] a) {
        int len = a.length;
        HashMap<Integer, ArrayList<Integer>> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            int n = a[i];
            if (!map1.containsKey(n)) {
                map1.put(n, new ArrayList<>());
                map2.put(n, 0);
            }
            map1.get(n).add(i);
            map2.put(n, map2.get(n) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map1.keySet());
        Collections.sort(list, (o1, o2) -> {
            return map2.get(o2) - map2.get(o1);
        });
        
        int answer = 0;
        for (int i: list) {
            ArrayList<Integer> nowList = map1.get(i);
            int nowListLen = map2.get(i);
            if (nowListLen <= answer) {
                break;
            }
            int cnt = 0;
            boolean[] visited = new boolean[len];
            for (int j = 0; j < nowListLen; j++) {
                int idx = nowList.get(j);
                int left = idx - 1;
                int right = idx + 1;
                if (left >= 0 && !visited[left] && a[left] != i) {
                    visited[idx] = true;
                    visited[left] = true;
                    cnt++;
                } else if (right < len && !visited[right] && a[right] != i) {
                    visited[idx] = true;
                    visited[right] = true;
                    cnt++;
                }
            }
            
            answer = Math.max(answer, cnt);
        }
        
        return answer * 2;
    }
}