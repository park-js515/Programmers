class Solution {
    private int answer = 1;
    private void check(String st, int start, int end, char before) {
        if (answer == 0) {
            return;
        }
        if (start == end) {
            if (st.charAt(start) == '1' && before == '0') {
                answer = 0;
            }
            return;
        }
        
        int mid = (start + end) / 2;
        char ch = st.charAt(mid);
        if (ch == '1' && before == '0') {
            answer = 0;
            return;
        }
        check(st, start, mid - 1, ch);
        check(st, mid + 1, end, ch);
    }
    
    public int[] solution(long[] numbers) {
        int len = numbers.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            long number = numbers[i];
            String st = Long.toBinaryString(number);
            int stLen = st.length();
            int k = 0;
            while (Math.pow(2, k) - 1 < stLen) {
                k++;
            }
            int targetLen = (int) Math.pow(2, k) - 1;
            int gap = targetLen - stLen;
            
            
            if (gap > 0) {
                StringBuilder sb = new StringBuilder(st);
                for (int j = 0; j < gap; j++) {
                    sb.insert(0, "0");
                }
                st = sb.toString();
            }
            
            answer = 1;
            check(st, 0, targetLen - 1, '1');
            arr[i] = Math.max(arr[i], answer);
        }
        
        return arr;
    }
}