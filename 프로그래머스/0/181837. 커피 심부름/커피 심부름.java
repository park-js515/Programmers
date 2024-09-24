class Solution {
    public int solution(String[] order) {
        int am = 4500;
        int lat = 5000;
        String A = "americano";
        String L = "cafelatte";
        
        int answer = 0;
        for (String s : order) {
            if (s.contains(A)) {
                answer += am;
            } else if (s.contains(L)) {
                answer += lat;
            } else {
                answer += am;
            }
        }
        
        return answer;
    }
}