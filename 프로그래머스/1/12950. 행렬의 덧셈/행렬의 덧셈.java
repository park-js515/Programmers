class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r = arr1.length;
        int c = arr1[0].length;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr2[i][j] += arr1[i][j];
            }
        }
        
        return arr2;
    }
}