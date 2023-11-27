class Solution {
    private static int answer = 0;
    private static boolean[] visited;
    private static void dfs(int n, int k, int[][] dungeons, int depth) {
        answer = Math.max(answer, depth);
        for (int i = 0; i < n; i++) {
            int[] dungeon = dungeons[i];
            if (!visited[i] && k >= dungeon[0]) {
                visited[i] = true;
                dfs(n, k - dungeon[1], dungeons, depth + 1);
                visited[i] = false;
            }    
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visited = new boolean[n];
        dfs(n, k, dungeons, 0);
        return answer;
    }
}