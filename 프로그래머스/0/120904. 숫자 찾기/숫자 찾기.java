class Solution {
    public int solution(int num, int k) {
        String s = Integer.toString(num);
        String target = Integer.toString(k);
        int answer = s.indexOf(target);
        
        return answer >= 0 ? answer + 1 : answer;
    }
}