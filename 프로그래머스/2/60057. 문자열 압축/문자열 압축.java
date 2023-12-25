class Solution {
    public int solution(String s) {
        int sLen = s.length();
        if (sLen == 1) {
            return 1;
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= sLen / 2; i++) {
            int tempLen = 0;
            int cnt = 1;
            String st = s.substring(0, i);
            for (int j = i; j < sLen; j += i) {
                String nextSt = s.substring(j, Math.min(sLen, j + i));
                if (st.equals(nextSt)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        tempLen += i + Integer.toString(cnt).length();
                    } else {
                        tempLen += i;
                    }
                    st = nextSt;
                    cnt = 1;
                }
            }
            if (cnt > 1) {
                tempLen += st.length() + Integer.toString(cnt).length();
            } else {
                tempLen += st.length();
            }
            
            answer = Math.min(answer, tempLen);
        }
        
        return answer;
    }
}