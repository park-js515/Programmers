import java.util.ArrayDeque;

class Solution {
    private boolean isComplete(String st) {
        ArrayDeque<Boolean> stack = new ArrayDeque<>();
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch == '(') {
                stack.add(true);
            } else {
                if (stack.isEmpty() || stack.peekLast() == false) {
                    return false;
                } else {
                    stack.pollLast();
                }
            }
        }
        
        boolean answer = stack.size() > 0 ? false : true;
        return answer;
    }
    
    private String dfs(String st) {
        // 1.
        if (st.length() == 0 || isComplete(st)) {
            return st;
        }
        
        // 2.
        int left = 0;
        int right = 0;
        String u = "", v = "";
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left > 0 && left == right) {
                u = st.substring(0, i + 1);
                v = st.substring(i + 1);
                break;
            }
        }
    
        // 3. ~ 4.
        if (isComplete(u)) {
            return u + dfs(v);
        }
        
        StringBuilder sb1 = new StringBuilder();
        sb1.append("(");
        sb1.append(dfs(v));
        sb1.append(")");
        StringBuilder sb2 = new StringBuilder();
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                sb2.append(')');
            } else {
                sb2.append('(');
            }
        }
        return sb1.toString() + sb2.toString();
    }
    
    public String solution(String p) {
        return dfs(p);
    }
}