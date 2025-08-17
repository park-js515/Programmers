class Solution {
    int n, target, sum, answer;
    int[] numbers;
    
    private void init(int[] numbers, int target) {
        this.n = numbers.length;
        this.target = target;
        this.sum = 0;
        this. answer = 0;
        this.numbers = numbers;
    }
    
    
    private void dfs(int depth) {
        if (depth == n) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        sum += numbers[depth];
        dfs(depth + 1);
        sum -= 2 * numbers[depth];
        dfs(depth + 1);
        sum += numbers[depth];
    }
    
    public int solution(int[] numbers, int target) {
        init(numbers, target);
        dfs(0);
        
        return answer;
    }
}