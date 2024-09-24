class Solution {
    public int solution(int[] numbers, int k) {
        int len = numbers.length;
        int index = (2 * (k - 1)) % len;
        
        return numbers[index];
    }
}