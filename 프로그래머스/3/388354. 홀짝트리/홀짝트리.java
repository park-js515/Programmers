// 미리 계산해둔 노드의 자식의 수를 이용하여 문제를 해결한다.

import java.util.*;

class Solution {
    private HashMap<Integer, Integer> cnt = new HashMap<>();
    private HashMap<Integer, List<Integer>> grp = new HashMap<>();
    private int[] arr = new int[1_000_001];
    private int[] answer = {0, 0};
    
    private void init(int[] nodes, int[][] edges) {
        for (int i = 1; i < 1_000_001; i ++) {
            arr[i] = i;
        }
        
        for (int node : nodes) {
            cnt.put(node, -1); // edge의 기본값을 -1로 두고, 루트 노드에 + 1 을 해주는 방식으로 해결
        }
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            cnt.put(a, cnt.get(a) + 1);
            cnt.put(b, cnt.get(b) + 1);
            
            union(a, b);
        }
        
        for (int i = 0; i < 1_000_001; i++) {
            int g = find(i);

            if (cnt.containsKey(g)) {
                grp.computeIfAbsent(g, k -> new ArrayList<>()).add(i);
            }
        }
    }
    
    private int find(int a) {
        if (arr[a] == a) {
            return a;
        }
        
        return arr[a] = find(arr[a]);
    }
    
    private void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        
        arr[x] = y;
    }
    
    private void solve() {
        for (int g : grp.keySet()) {
            List<Integer> list = grp.get(g);
            int[] status = {0, 0};
            int[] checkValue = {0, 0};
            
            if (list.size() == 1 && list.get(0) % 2 == 0) { // 위에서 언급한 -1 초기값으로 인해 필터링 해야함.
                answer[0]++;
                continue;
            }
            
            for (int k : list) {
                if (k % 2 == cnt.get(k) % 2) {
                    checkValue[0]++;
                } else {
                    checkValue[1]++;
                }
            }
            

            for (int i = 0; i < list.size(); i++) {
                if (status[0] == 1 && status[1] == 1) {
                    break;
                }
                
                int k = list.get(i);
                int gap = k % 2 == (cnt.get(k) + 1) % 2 ? 1 : -1;

                checkValue[0] -= gap;
                checkValue[1] += gap;

                if (checkValue[0] == 0) {
                    status[1] = 1;
                } else if (checkValue[1] == 0) {
                    status[0] = 1;
                }

                checkValue[0] += gap;
                checkValue[1] -= gap;
            }
            
            answer[0] += status[0];
            answer[1] += status[1];
            
        }
    }
    
    public int[] solution(int[] nodes, int[][] edges) {
        init(nodes, edges);
        solve();
        
        return answer;
    }
}