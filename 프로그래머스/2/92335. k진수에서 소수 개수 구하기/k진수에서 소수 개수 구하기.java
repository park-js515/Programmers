class Solution {
    private static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        for (long i = 2; i <= (long)Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int solution(int n, int k) {
        String translate = Integer.toString(n, k);
        System.out.println(translate);
        int len = translate.length();
        
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = translate.charAt(i);
            if (ch != '0') {
                sb.append(ch);
            } else {
                String st = sb.toString();
                sb = new StringBuilder();
                if (st.length() > 0) {
                    long num = Long.parseLong(st);
                    if (isPrime(num)) {
                        answer++;
                    }
                }
            }
        }
        
        String st = sb.toString();
        if (st.length() > 0) {
            long num = Long.parseLong(st);
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
}