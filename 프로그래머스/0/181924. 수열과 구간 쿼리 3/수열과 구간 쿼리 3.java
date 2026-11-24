class Solution {
    private void chg(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            chg(arr, query[0], query[1]);
        }
        
        return arr;
    }
}