class Solution {
    private int pow(int num, int mul) {
        int ret = 1;
        for (int i = 0; i < mul; i++) {
            ret *= num;
        }
        
        return ret;
    }
    
    public int solution(int a, int b, int c) {
        int val = 0;
        if (a == b) val++;
        if (a == c) val++;
        if (b == c) val++;
        if (val <= 1) val++;
        
        int answer = 1;
        for (int i = 1; i <= val; i++) {
            answer *= (pow(a, i) + pow(b, i) + pow(c, i));
        }
        
        return answer;
    }
}