class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_strings.length; i++) {
            int[] part = parts[i];
            String my_string = my_strings[i];
            sb.append(my_string.substring(part[0], part[1] + 1));
        }
        
        return sb.toString();
    }
}