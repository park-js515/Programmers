class Solution {
    public String solution(int n, int t, int m, int p) {
        p--;
        StringBuilder sb = new StringBuilder();
        int num = 0;
        String st = "0";
        int len = st.length();
        int digit = 0;
        int order = 0;
        int turn = -1;
        
        while (digit < t) {
            if (order < len) {
                if (++turn % m == p) {
                    sb.append(st.charAt(order));
                    digit++;
                }
                order++;
            } else {
                order = 0;
                st = Integer.toString(++num, n);
                len = st.length();
            }
        }
        
        return sb.toString().toUpperCase();
    }
}