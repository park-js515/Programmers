class Solution {
    public String solution(String polynomial) {
        int x = 0;
        int n = 0;
        
        polynomial = polynomial.replace(" + ", " ");
        String[] split = polynomial.split(" ");
        for (String s : split) {
            if (s.endsWith("x")) {
                if (s.length() == 1) {
                    x += 1;
                } else {
                    x += Integer.parseInt(s.substring(0, s.length() - 1));
                }
            } else {
                n += Integer.parseInt(s);
            }
        }
        
        String answer = "";
        if (x > 0) {
            if (x == 1) {
                answer= answer + "x";
            } else {
                answer = answer + x + "x";
            }
        }
        if (n > 0) {
            if (x > 0) {
                answer = answer + " + " + n;
            } else {
                answer = answer + n;
            }
        }       
        return answer;
    }
}