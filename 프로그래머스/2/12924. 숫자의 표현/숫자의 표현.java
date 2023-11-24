class Solution {
    public int solution(int n) {
        int answer = 0;
        int left = 0, right = 0;
        int sum = 0;
        
        while (left <= right && right <= n) {
            if (sum < n) {
                sum += ++right;
            } else if (sum == n) {
                answer++;
                sum += ++right;
            } else {
                sum -= left++;
            }
        }
        return answer;
    }
}