class Solution {
    private String getAnswer(String s) {
        int len = s.length();
        if (len <= 3) {
            return s;
        }
        
        int cnt = 0;
        int targets = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            cnt++;
            sb.append(s.charAt(i));
            
            if (cnt >= 3 && sb.substring(cnt - 3, cnt).equals("110")) {
                sb.delete(cnt - 3, cnt);
                cnt -= 3;
                targets++;
            }
        }
        
        StringBuilder ret = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                flag = true;
                break;
            }
        }
        
        if (flag) {
            for (int i = cnt - 1; i >= 0; i--) {
                if (sb.charAt(i) == '0') {
                    ret = new StringBuilder(sb.substring(0, i + 1));
                    for (int j = 0 ; j < targets; j++) {
                        ret.append("110");
                    }
                    ret.append(sb.substring(i + 1));
                    break;
                }
            }
        } else {
            for (int i = 0; i < targets; i++) {
                ret.append("110");
            }
            ret.append(sb.toString());
        }
        
        return ret.toString();
    }
    public String[] solution(String[] s) {
        int len = s.length;
        String[] answer = new String[len];
        for (int i = 0; i < len; i++) {
            answer[i] = getAnswer(s[i]);
        }
        
        return answer;
    }
}