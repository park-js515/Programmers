import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        Arrays.sort(phone_book, (o1, o2) -> o1.length() - o2.length());
        
        for (String p : phone_book) {
            for (int i = 1; i <= p.length(); i++) {
                if (set.contains(p.substring(0, i))) {
                    return false;
                }
            }
            
            set.add(p);
        }
        
        return true;
    }
}