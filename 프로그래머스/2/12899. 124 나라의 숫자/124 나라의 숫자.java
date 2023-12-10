class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] arr = {1, 2, 4};
        n--;
        while (n >= 0) {
            int r = n % 3;
            sb.insert(0, Integer.toString(arr[r]));
            n = (n / 3) - 1;
        }
        
        return sb.toString();
    }
}