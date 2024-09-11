class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] add = new int[len + 1];
        
        for (int[] query : queries) {
            add[query[0]]++;
            add[query[1] + 1]--;
        }
        
        int temp = 0;
        for (int i = 0; i < len; i++) {
            temp += add[i];
            arr[i] += temp;
        }
        
        return arr;
    }
}