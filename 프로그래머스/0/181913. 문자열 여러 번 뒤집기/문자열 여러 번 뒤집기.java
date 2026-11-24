class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        for (int[] query : queries) {
            StringBuilder temp = new StringBuilder(sb.substring(query[0], query[1] + 1));
            sb.replace(query[0], query[1] + 1, temp.reverse().toString());
        }
        
        return sb.toString();
    }
}