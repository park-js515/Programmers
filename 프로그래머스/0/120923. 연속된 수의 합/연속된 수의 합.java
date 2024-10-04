class Solution {
    public int[] solution(int num, int total) {
        int left = 1;
        int right = num;
        int sum = (num * (num + 1)) / 2;

        while (sum != total) {
            if (sum < total) {
                sum -= left++;
                sum += ++right;
            } else {
                sum -= right--;
                sum += --left;
            }
        }
        
        int[] answer = new int[num];
        int index = 0;
        for (int i = left; i <= right; i++) {
            answer[index++] = i;
        }
        
        return answer;
    }
}