import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        Arrays.sort(phone_book, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        for (String phone: phone_book) {
            for (int i = 1; i <= phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
            set.add(phone);
        }
        return true;
    }
}