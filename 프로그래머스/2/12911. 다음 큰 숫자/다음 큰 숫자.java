class Solution {
    private static int countOnes(int s) {
        String sToB = Integer.toBinaryString(s);
        int cnt = 0;
        for (int i = 0; i < sToB.length(); i++) {
            if (sToB.charAt(i) == '1') {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    public int solution(int n) {
        int cnt = countOnes(n);
        int now = n + 1;
        
        while (true) {
            if (cnt == countOnes(now)) {
                return now;
            }
            now++;
        }
    }
}