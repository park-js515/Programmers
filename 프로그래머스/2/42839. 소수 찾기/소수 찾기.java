class Solution {
    boolean[] isNotPrime = new boolean[10_000_001];
    private boolean[] check = new boolean[10_000_001];
    private int answer = 0;
    
    private void init() {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= (int) Math.sqrt(10_000_001); i++) {
            if (isNotPrime[i]) continue;
            for (int j = i * 2; j <= 10_000_000; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
    
    private void dfs(String numbers, int num, int depth, int n, boolean[] visited) {
        if (!isNotPrime[num] && !check[num]) {
            check[num] = true;
            answer++;
        }
        
        int pow = (int) Math.pow(10, depth);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int d = pow * (numbers.charAt(i) - '0');
                dfs(numbers, num + d, depth + 1, n, visited);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        init();
        dfs(numbers, 0, 0, numbers.length(), new boolean[numbers.length()]);
        
        return answer;
    }
}