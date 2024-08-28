class Solution {
    public int[] solution(int[] arr, int n) {
        int a = 1 - (arr.length % 2);
        
        for (int i = a; i < arr.length; i += 2) {
            arr[i] += n;
        }
        
        return arr;
    }
}