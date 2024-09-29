class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        int total = spell.length;
        
        for (String d : dic) {
            int cnt = 0;
            for (String s : spell) {
                if (d.contains(s)) cnt++;
            }
            if (cnt == total) {
                answer = 1;
                break;
            }
        }
        
        return answer;
    }
}