class Solution {
    private boolean[] getNotPrime(int n) {
        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!arr[i]) {
                for (int j = i + i; j <= n; j += i) {
                    arr[j] = true;
                }
            }
        }
        
        return arr;
    }
    
    public int solution(int n) {
        boolean[] notPrime = getNotPrime(n);
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (notPrime[i]) answer++;            
        }
        
        return answer;
    }
}