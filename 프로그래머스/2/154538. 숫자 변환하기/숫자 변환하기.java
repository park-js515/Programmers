import java.util.ArrayDeque;

class Solution {
    public int solution(int x, int y, int n) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[y + 1];
        queue.add(x);
        visited[x] = 1;
        
        while (!queue.isEmpty() && visited[y] == 0) {
            int now = queue.poll();
            int[] arr = {now + n, now * 2, now * 3};
            for (int i: arr) {
                if (i <= y && visited[i] == 0) {
                    visited[i] = visited[now] + 1;
                    queue.add(i);
                }
            }
        }
        
        return visited[y] - 1;   
    }
}