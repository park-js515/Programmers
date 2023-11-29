import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        Arrays.sort(phone_book, (o1, o2) -> {
            return o1.length() - o2.length();
        }); // 접두사로 올 수 있는 것은 자신보다 짧은 길이이어야 하므로 오름차순으로 정렬합니다.
        for (String phone: phone_book) {
            for (int i = 1; i <= phone.length(); i++) { 
                if (set.contains(phone.substring(0, i))) { // String을 처음부터 끝까지 순회하면서 포함여부를 확인합니다.
                    return false;
                }
            }
            set.add(phone);
        }
        return true;
    }
}