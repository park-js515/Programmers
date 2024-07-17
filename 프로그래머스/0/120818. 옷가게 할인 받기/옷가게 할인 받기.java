class Solution {
    public int solution(int price) {
        double answer = (double) price;
        if (answer >= 500_000) {
            answer *= 0.8;
        } else if (answer >= 300_000) {
            answer *= 0.9;
        } else if (answer >= 100_000) {
            answer *= 0.95;
        }
        
        return (int) answer;
    }
}