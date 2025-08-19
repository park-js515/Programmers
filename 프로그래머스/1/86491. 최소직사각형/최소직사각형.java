class Solution {
    public int solution(int[][] sizes) {
        for (int[] size : sizes) {
            int a = size[0];
            int b = size[1];
            
            if (a > b) {
                size[0] = b;
                size[1] = a;
            }
        }
        
        int a = 0;
        int b = 0;
        
        for (int[] size : sizes) {
            a = Math.max(a, size[0]);
            b = Math.max(b, size[1]);
        }
        
        return a * b;
    }
}