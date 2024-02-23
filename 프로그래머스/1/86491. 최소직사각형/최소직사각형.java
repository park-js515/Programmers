class Solution {
    public int solution(int[][] sizes) {
        int w = 0, h = 0;
        for (int[] size: sizes) {
            int x = size[0];
            int y = size[1];
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            w = Math.max(w, y);
            h = Math.max(h, x);
        }
        
        return w * h;
    }
}