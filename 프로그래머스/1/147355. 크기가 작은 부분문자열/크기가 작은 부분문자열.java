class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pValue = Long.parseLong(p);
    
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            String s = t.substring(i, i + p.length());
            long sValue = Long.parseLong(s);
            if (pValue >= sValue) answer++;
        }
        
        return answer;
    }
}