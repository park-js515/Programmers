class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        for (int i = 0; i < n ; i++) {
            answer[i] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int val = query[2];
            for (int j = query[0]; j <= query[1]; j++) {
                if (val < arr[j]) {
                    if (answer[i] == -1) {
                        answer[i] = arr[j];
                    } else {
                        answer[i] = Math.min(answer[i], arr[j]);
                    }
                }
            }
        }
        return answer;
    }
}