import java.util.*;

class Solution {
    private String calc(Exp exp, int radix) {
        int a;
        int b;
        
        try {
            a = Integer.parseInt(exp.A, radix);
        } catch (Exception e) {
            return "-1";
        }
        
        try {
            b = Integer.parseInt(exp.B, radix);
        } catch (Exception e) {
            return "-1";
        }
        
        return Integer.toString(a + exp.op * b, radix);
    }
    
    private boolean check(Exp exp, int radix) {
        if (exp.C.equals("X")) {
            return !calc(exp, radix).equals("-1");
        }
        return exp.C.equals(calc(exp, radix));
    }
    
    private String getResult(Exp exp, int radix, boolean flag) {
        StringBuilder sb = new StringBuilder();
        sb.append(exp.A);
        sb.append(exp.op == 1 ? " + " : " - ");
        sb.append(exp.B);
        sb.append(" = ");
        if (flag) {
            sb.append("?");
        } else {
            sb.append(calc(exp, radix));    
        }
        
        return sb.toString();
    }
    
    public String[] solution(String[] expressions) {
        boolean[] isMatchFalse = new boolean[10];
        List<Exp> q1 = new ArrayList<>();
        List<Exp> q2 = new ArrayList<>();
        
        for (String expression : expressions) {
            Exp exp = new Exp(expression);
            if (exp.isQuestion) {
                q2.add(exp);
            } else {
                q1.add(exp);
            }
        }
        
        for (Exp exp : q1) {
            for (int i = 2; i < 10; i++) {
                if (!isMatchFalse[i]) {
                    if (!check(exp, i)) {
                        isMatchFalse[i] = true;
                    }
                }
            }
        }
        
        for (Exp exp : q2) {
            for (int i = 2; i < 10; i++) {
                if (!isMatchFalse[i]) {
                    if (!check(exp, i)) {
                        isMatchFalse[i] = true;
                    }
                }
            }
        }
        
        List<String> answer = new ArrayList<>();
        for (Exp exp : q2) {
            String s = "init";
            for (int i = 2; i < 10; i++) {
                if (!isMatchFalse[i]) {
                    String result = getResult(exp, i, false);
                    if (s.equals("init")) {
                        s = result;
                    } else if (!s.equals(result)) {
                        s = getResult(exp, i, true);
                    }
                }
            }
                            
            if (!s.equals("init") && !s.equals("")) {
                answer.add(s);
            }
        }

        return answer.stream().toArray(String[]::new);
    }
    
    
    private class Exp {
        String A, B, C;
        int op;
        boolean isQuestion;
        
        public Exp(String exp) {
            String[] splited = exp.split(" ");
            this.A = splited[0];
            this.B = splited[2];
            this.C = splited[4];
            this.isQuestion = C.equals("X");
            this.op = splited[1].equals("+") ? 1 : -1;
        }
    }
}