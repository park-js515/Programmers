class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] DAT = new int[1001];
        for (int weight: weights) {
            DAT[weight]++;
        }
        for (int i = 100; i <= 1000; i++) {
            int cnt = DAT[i];
            if (cnt >= 2) {
                answer += ((long)cnt * (cnt - 1)) / 2;
            }
        }
        
        int[][] arr = {{2, 3}, {3, 4}, {1, 2}};
        for (int i = 100; i <= 1000; i++) {
            for (int[] a: arr) {
                if (i % a[0] != 0 || i / a[0] * a[1] > 1000) continue;
                answer += (long)DAT[i] * DAT[i / a[0] * a[1]];
            }
        }
        
        return answer;
    }
}