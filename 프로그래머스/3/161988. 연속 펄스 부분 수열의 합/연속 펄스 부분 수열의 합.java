class Solution {
    public long solution(int[] sequence) {
        int len = sequence.length;
        long[] arr1 = new long[len], arr2 = new long[len];
        int sign = 1;
        arr1[0] = sequence[0] * -1;
        arr2[0] = sequence[0];
        
        for (int i = 1; i < len; i++) {
            long s = sequence[i];
            long val1 = Math.max(0, arr1[i - 1]);
            long val2 = Math.max(0, arr2[i - 1]);
            arr1[i] = (s * sign) + val1;
            arr2[i] = (s * sign * -1) + val2;
            sign *= -1;
        }
        
        long answer = Long.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            answer = Math.max(answer, arr1[i]);
            answer = Math.max(answer, arr2[i]);
        }

        return answer;
    }
}