class Solution {
    private int answer = 0;
    
    private double getGradient(int[] dot1, int[] dot2) {
        double x1 = dot1[0], y1 = dot1[1], x2 = dot2[0], y2 = dot2[1];
        
        return (y1 - y2) / (x1 - x2);
    }
    
    public int solution(int[][] dots) {
        boolean[] visited = new boolean[4];
        point : for (int i = 0; i < 4; i++) {
            visited[i] = true;
            for (int j = i + 1; j < 4; j++) {
                visited[j] = true;
                int[] a = new int[2];
                int index = 0;
                for (int k = 0; k < 4; k++) {
                    if (!visited[k]) {
                        a[index++] = k; 
                    }
                }
                
                if (getGradient(dots[i], dots[j]) == getGradient(dots[a[0]], dots[a[1]])) {
                    answer = 1;
                    break point;
                }
                visited[j] = false;
            }
            visited[i] = false;
        }
        
        return answer;
    }
}