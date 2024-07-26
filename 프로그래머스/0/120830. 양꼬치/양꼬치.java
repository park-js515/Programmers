class Solution {
    public int solution(int n, int k) {
        int lamb = 12000;
        int beverage = 2000;
        k -= n / 10;
        
        int answer = 0;
        answer += n * lamb;
        if (k > 0) answer += k * beverage;
        
        return answer;
    }
}