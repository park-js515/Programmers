// 문자 -> 숫자
// 숫자 -> 문자

import java.util.Arrays;

class Solution {
    private long stringToNum(String s) {
        long ret = 0L;
        long k = 26L;
        
        ret += s.charAt(s.length() - 1) - 'a';
        for (int i = s.length() - 2; i >= 0; i--) {
            ret += (s.charAt(i) - 'a' + 1) * k;
            k *= 26L;
        }
        
        return ret;
    }
    
    private String numToString(long num) {
        StringBuilder sb = new StringBuilder();
        long d = 0;
        
        while (num >= 26) {
            d = num % 26;
            num /= 26;
            num--;
            sb.append((char)('a' + d));
        }
        sb.append((char)('a' + (num % 26)));
        
        return sb.reverse().toString();
    }
    
    public String solution(long n, String[] bans) {
        long[] deList = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            deList[i] = stringToNum(bans[i]);
        }
        Arrays.sort(deList);
        
        n--;
        for (long ban : deList) {
            if (n >= ban) {
                n++;
            }
        }
        
        return numToString(n);
    }
}