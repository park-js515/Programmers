class Solution {
    private final String[] nums = {"zero", "one", "two", "three", "four", 
                                   "five", "six", "seven", "eight", "nine"};
    
    public long solution(String numbers) {
        long answer = 0;
        int index = 0;
        
        while (index < numbers.length()) {
            for (int i = 0; i < 10; i++) {
                if (numbers.startsWith(nums[i], index)) {
                    index += nums[i].length();
                    answer *= 10;
                    answer += i;
                }
            }
        }
        
        return answer;
    }
}