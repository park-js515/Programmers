class Solution {
    public int solution(int[] numbers) {
        int a = numbers[0];
        int b = 0;
        
        for (int i = 1; i < numbers.length; i++) {
            if (b < numbers[i]) {
                b = numbers[i];
                
                if (b > a) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
            }
        }
        
        return a * b;
    }
}