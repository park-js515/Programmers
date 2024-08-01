import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            char ch1 = o1.charAt(n);
            char ch2 = o2.charAt(n);
            
            if (ch1 == ch2) {
                return o1.compareTo(o2);
            }
            return Character.compare(ch1, ch2);
        });
        
        return strings;
    }
}