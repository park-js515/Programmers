class Solution {
    public int[] solution(String my_string) {
        int[] result = new int[52];
        
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            int index = Character.isUpperCase(ch) ? ch - 'A' : ch - 'a' + 26;
            result[index]++;
        }
        
        return result;
    }
}