class Solution {
    private static int find(int[] grp, int a) {
        if (grp[a] == a) {
            return a;
        }
        
        grp[a] = find(grp, grp[a]);
        return grp[a];
    }
    
    private static void union(int[] grp, int a, int b) {
        int x = find(grp, a);
        int y = find(grp, b);
        
        grp[y] = x;
    }
    
    public int solution(int n, int[][] computers) {
        int[] grp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            grp[i] = i;
        }
        
        int answer = n;
        for (int i = 0; i < n; i++) {
            int[] links = computers[i];
            for (int j = i + 1; j < n; j++) {
                if (links[j] == 1 && find(grp, i) != find(grp, j)) {
                    answer--;
                    union(grp, i, j);
                }
            }
        }
        
        return answer;
    }
}