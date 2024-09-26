class Solution {
    public String solution(String my_string, int[][] queries) {
        int len = my_string.length();
        for (int[] query : queries) {
            String s1 = my_string.substring(0, query[0]);
            StringBuilder sb = new StringBuilder(my_string.substring(query[0], query[1] + 1)).reverse();
            String s2 = my_string.substring(query[1] + 1, len);
            
            my_string = s1 + sb.toString() + s2;
        }
        
        return my_string;
    }
}