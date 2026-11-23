class Solution {
    int pow(int a, int b) {
        int t = 1;
        
        for (int i = 0; i < b; i++) {
            t *= a;
        }
        
        return t;
    }
    
    public int solution(int a, int b, int c) {
        int answer = a + b + c;
        int t1 = a == b ? 1 : 0;
        int t2 = a == c ? 1 : 0;
        int t3 = b == c ? 1 : 0;
        int t = t1 + t2 + t3;
        
        if (t >= 1) {
            answer *= (pow(a, 2) + pow(b, 2) + pow(c, 2));
        }
        if (t >= 2) {
            answer *= (pow(a, 3) + pow(b, 3) + pow(c, 3));
        }
        
        return answer;
    }
}