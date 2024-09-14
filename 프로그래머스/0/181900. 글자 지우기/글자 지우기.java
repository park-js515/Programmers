class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder(my_string);
        for (int index : indices) {
            sb.replace(index, index + 1, " ");
        }
        
        return sb.toString().replace(" ", "");
        
    }
}