import java.util.Arrays;

// 대충 l = 10000 쯤으로 큰 숫자로 확인하고 문제 풀어도 무방하나, 최적화 생각하면 최소공배수는 맞다.

class Solution {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
    
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                size[i] += signals[i][j];
            }
        }
        
        int l = 1;
        for (int i = 0; i < n; i++) {
            l = lcm(l, size[i]);
        }
        
        int[] checkList = new int[l];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l / size[i]; j++) {
                int y = j * size[i] + signals[i][0];
                for (int k = 0; k < signals[i][1]; k++) {
                    checkList[y + k] += 1;
                }
            }
        }
        
        int answer = -1;
        for (int i = 0; i < l; i++) {
            if (checkList[i] == n) {
                return i + 1;
            }
        }
        
        return answer;
    }
}