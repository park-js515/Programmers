import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        k--;
        int[] answer = new int[n];
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for (int i = 0; i < n - 1; i++) {
            int idx = (int) (k / factorial[n - 1 - i]);
            k %= factorial[n - 1 - i];
            answer[i] = list.remove(idx);
        }
        answer[n - 1] = list.remove(0);
        
        return answer;
    }
}