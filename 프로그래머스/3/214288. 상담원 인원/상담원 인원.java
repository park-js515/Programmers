import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Arrays;


class Solution {
    private int answer = Integer.MAX_VALUE;
    private int[][] cost;
    
    private int calc(List<Node> list, int k) {
        int time = 0;
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (cnt < k) {
                cnt++;
                pq.add(node.s + node.e);
            } else {
                int poll = pq.poll();
                if (poll >= node.s) {
                    time += poll - node.s;
                    pq.add(poll + node.e);
                } else {
                    pq.add(node.s + node.e);
                }
            }
        }
        
        return time;
    }
    
    private void dfs(int n, int k, int depth, int used, int[] arr) {
        if (depth == k) {
            arr[depth] = n - k - used;
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += cost[i][arr[i] + 1];
            }
            answer = Math.min(answer, sum);
            return;
        }
        
        for (int i = 0; i <= n - k - used; i++) {
            arr[depth] = i;
            dfs(n, k, depth + 1, used + i, arr);
        }
    }
    
    public int solution(int k, int n, int[][] reqs) {
        List<Node>[] list = new ArrayList[k + 1];
        for (int i = 0; i < k + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] req: reqs) {
            int s = req[0];
            int e = req[1];
            int idx = req[2];
            list[idx].add(new Node(s, e));
        }
        
        cost = new int[k + 1][n - k + 2];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n - k + 1; j++) {
                cost[i][j] = calc(list[i], j);
            }
        }
        
        for (int[] c: cost) {
            System.out.println(Arrays.toString(c));
        }
        dfs(n, k, 1, 0, new int[k + 1]);
        return answer;
    }
    
    private class Node {
        int s, e;
        
        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}