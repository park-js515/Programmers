class Solution {
    private boolean[] isPrime(int n) {
        boolean[] numbers = new boolean[n + 1];
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (numbers[i]) continue;
            for (int j = i * 2; j <= n; j += i) {
                numbers[j] = true;
            }
        }
        
        return numbers;
    }
    
    public int solution(int n) {
        int answer = 0;
        boolean[] isPrime = isPrime(n);
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}