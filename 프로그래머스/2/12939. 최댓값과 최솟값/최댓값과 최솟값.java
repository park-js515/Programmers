import java.util.*;

class Solution {
    public String solution(String s) {
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] strs = s.split(" ");      
        
        for (String str: strs) {
            numbers.add(Integer.parseInt(str));
        }
        int len = numbers.size();
        Collections.sort(numbers);
        String answer = "" + numbers.get(0) + " " + numbers.get(len - 1);
        
        return answer;
    }
}