class Solution {
    public String solution(String s) {
        String[] splited = s.split(" ");
        int min, max;
        min = max = Integer.parseInt(splited[0]);
        
        for (int i = 1; i < splited.length; i++) {
            min = Math.min(min, Integer.parseInt(splited[i]));
            max = Math.max(max, Integer.parseInt(splited[i]));
        }
        
        return min + " " + max;
    }
}