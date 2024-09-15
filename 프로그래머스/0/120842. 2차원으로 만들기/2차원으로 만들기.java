class Solution {
    public int[][] solution(int[] num_list, int n) {
        int r = num_list.length / n;
        int[][] answer = new int[r][n];
        
        for (int i = 0; i < num_list.length; i++) {
            int dr = i / n;
            int dc = i % n;
            answer[dr][dc] = num_list[i];
        }
        
        return answer;
    }
}