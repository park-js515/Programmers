// 자료 구조를 통해서 해당 노드로 내려가는 로직을 계산한다.
// result에 순서를 고려해야 하므로, 타겟에 값을 저장할 때는 노드의 값을 저장한 후, 정렬 후 반환한다.
// 현재까지의 방문한 노드들을 확인하고, 만들 수 있는 숫자인지 확인한다.
// 311 vs 221 -> 1를 최대한 많이 써야 빠른 순서가 된다.

import java.util.*;

class Solution {
    private int N;
    private List<Integer>[] adjList;
    private List<Integer> order = new ArrayList<>();
    private Map<Integer, Integer> orderMap = new HashMap<>();
    private int[] counts;
    
    private void init(int[][] edges) {
        this.N = edges.length + 1;
        this.adjList = new ArrayList[N + 1];
        this.counts = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            adjList[edge[0]].add(edge[1]);
        }
        for (List<Integer> list: adjList) {
            Collections.sort(list);
        }
    }
    
    private int findLeaf() {
        int node = 1;
        while (!adjList[node].isEmpty()) {
            int index = counts[node]++ % adjList[node].size();
            node = adjList[node].get(index);
        }
        
        return node;
    }
    
    // 1 성공, 0 아직 모름, -1 실패
    private int check(int[] target) {
        int[] values = new int[N + 1];
        for (int k: orderMap.keySet()) {
            int v = orderMap.get(k);
            if (target[k - 1] < v) {
                return -1;
            }
            values[k] = Math.min(3 * v, target[k - 1]);
        }
        
        for (int i = 0; i < N; i++) {
            if (values[i + 1] != target[i]) {
                return 0;
            }
        }
        
        return 1;
    }
    
    private int[] getAnswer(int[] target) {
        List<Integer>[] list = new ArrayList[N + 1];
        List<Integer> answer = new ArrayList<>();
        int[] temp = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int k: orderMap.keySet()) {
            int v = orderMap.get(k);
            int left = target[k - 1];
            for (int i = 1; i <= v; i++) {
                if (left - 1 <= 3 * (v - i)) {
                    left -= 1;
                    list[k].add(1);
                } else if (left - 2 <= 3 * (v - i)) {
                    left -= 2;
                    list[k].add(2);
                } else {
                    left -= 3;
                    list[k].add(3);
                }
            }
        }
        
        for (int k: order) {
            answer.add(list[k].get(temp[k]++));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int[] solution(int[][] edges, int[] target) {
        init(edges);
        
        int[] answer = {-1};    
        while (true) {
            int leaf = findLeaf();
            order.add(leaf);
            orderMap.put(leaf, orderMap.getOrDefault(leaf, 0) + 1);
            int flag = check(target);
            if (flag == -1) {
                return answer;
            }
            if (flag == 1) {
                answer = getAnswer(target);
                break;
            }
        }
        
        return answer;
    }
}