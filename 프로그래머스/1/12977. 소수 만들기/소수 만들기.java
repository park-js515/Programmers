class Solution {
    private boolean[] getPrime(int n) {
        boolean[] numbers = new boolean[n + 1];
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (!numbers[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    numbers[j] = true;
                }
            }
        }
        
        return numbers;
    }
    
    public int solution(int[] nums) {
        boolean[] isPrime = getPrime(3000);
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (!isPrime[sum]) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}