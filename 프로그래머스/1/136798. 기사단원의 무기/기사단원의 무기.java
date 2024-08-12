class Solution {
    public int solution(int number, int limit, int power) {
        int[] divisors = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                divisors[i * j]++;
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= number; i ++) {
            answer += divisors[i] > limit ? power : divisors[i];
        }
        
        return answer;
    }
}