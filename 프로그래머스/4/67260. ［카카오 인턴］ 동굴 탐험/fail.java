// 양방향이지만 부모 자식 관계는 존재한다가 할 수 있다.
// 자식은 부모를 방문하기 전에 방문할 수 없다.
// 이 관계를 이용하여 푼다.

// 위의 방법이 비용이 너무 많이 들 것으로 생각되면 edge point와 hashmap을 활용해 보자.
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    private List<Integer>[] adjList;
    private Set<Integer> set = new HashSet<>();
    private Map<Integer, Integer> map = new HashMap<>();
    private boolean[] visited;
    
    private void init(int n, int[][] path, int[][] order) {
        this.adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            this.adjList[i] = new ArrayList<>();
        }
        for (int[] p: path) {
            this.adjList[p[0]].add(p[1]);
            this.adjList[p[1]].add(p[0]);
        }
        
        for (int[] o: order) {
            set.add(o[1]);
            map.put(o[1], o[0]);
        }
        this.visited = new boolean[n];
    }
    
    public boolean solution(int n, int[][] path, int[][] order) {
        init(n, path, order);
        
        int cnt = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        
        boolean answer = true;
        point: while (cnt != n) {
            int beforeCnt = cnt;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                
                boolean flag = true;
                if (set.contains(node)) {
                    int before = map.get(node);
                    if (!visited[before]) {
                        flag = false;
                    }
                }
                
                if (flag) {
                    beforeCnt++;
                    set.remove(node);
                    map.remove(node);
                    visited[node] = true;
                    for (int child: adjList[node]) {
                        if (!visited[child]) {
                            queue.add(child);
                        }
                    }
                } else {
                    queue.add(node);
                }
            }
            
            if (beforeCnt == cnt) {
                answer = false;
                break point;
            }
            cnt = beforeCnt;
        }
        
        return answer;
    }
}
