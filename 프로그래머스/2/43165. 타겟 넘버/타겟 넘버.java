class Solution {
    private static int answer = 0;
    private static void dfs(int[] numbers, int target, int value, int N, int depth) {
        if (depth < N) {
            dfs(numbers, target, value + numbers[depth], N, depth + 1);
            dfs(numbers, target, value - numbers[depth], N, depth + 1);
        } else {
            if (target == value) {
                answer++;
            }
        }
        
    }
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, numbers.length, 0);
        return answer;
    }
}