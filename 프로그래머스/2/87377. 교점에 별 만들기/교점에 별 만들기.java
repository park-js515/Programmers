import java.util.HashSet;

class Solution {
    private Point getPoint(int[] line1, int[] line2) {
        double[] l1 = {(double) line1[0], (double) line1[1], (double) line1[2]};
        double[] l2 = {(double) line2[0], (double) line2[1], (double) line2[2]};
        double AD_BC = (l1[0] * l2[1]) - (l1[1] * l2[0]);
        double BF_ED = (l1[1] * l2[2]) - (l1[2] * l2[1]);
        double EC_AF = (l1[2] * l2[0]) - (l1[0] * l2[2]);
        
        if (AD_BC == 0 || (BF_ED / AD_BC) % 1 != 0 || (EC_AF / AD_BC) % 1 != 0) {
            return new Point(false, 0, 0);
        }
        return new Point(true, (long) (BF_ED / AD_BC), (long) (EC_AF / AD_BC));
    }
    
    public String[] solution(int[][] line) {
        HashSet<Point> set = new HashSet<>();
        long yMin = Long.MAX_VALUE;
        long yMax = Long.MIN_VALUE;
        long xMin = Long.MAX_VALUE;
        long xMax = Long.MIN_VALUE;
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point point = getPoint(line[i], line[j]);
                if (point.available) {
                    set.add(point);
                    yMin = Math.min(yMin, point.y);
                    yMax = Math.max(yMax, point.y);
                    xMin = Math.min(xMin, point.x);
                    xMax = Math.max(xMax, point.x);
                }
            }
        }
        
        int yLen = (int) (yMax - yMin + 1);
        int xLen = (int) (xMax - xMin + 1);
        StringBuilder[] sb = new StringBuilder[yLen];
        String[] answer = new String[yLen];
        for (int i = 0; i < yLen; i++) {
            sb[i] = new StringBuilder();
            for (int j = 0; j < xLen; j++) {
                sb[i].append(".");
            }
        }
        for (Point point: set) {
            sb[(int) (point.y - yMin)].setCharAt((int) (point.x - xMin), '*');
        }
        for (int i = 0; i < yLen; i++) {
            answer[i] = sb[(int) (yLen - i - 1)].toString();
        }
        return answer;
    }
    
    private class Point {
        boolean available;
        long x, y;
        
        public Point(boolean available, long x, long y) {
            this.available = available;
            this.x = x;
            this.y = y;
        }        
    }
}