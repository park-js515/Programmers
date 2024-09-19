class Solution {
    public String[] solution(String myStr) {
        myStr = myStr.replaceAll("[a-c]", " ");
        myStr = myStr.replaceAll("\\s+", " ");
        myStr = myStr.trim();
        
        String[] answer = myStr.split(" ");
        return myStr.equals("") ? new String[] {"EMPTY"} : answer;
    }
}