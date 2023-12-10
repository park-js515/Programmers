import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    private static boolean[] visited;
    private static boolean[][] matrix;
    private static ArrayList<HashSet<String>> list = new ArrayList<>();
    
    private static boolean coincide(String st1, String st2) {
        int len1 = st1.length();
        int len2 = st2.length();
        if (len1 != len2)  return false;
        
        for (int i = 0; i < len1; i++) {
            if (st2.charAt(i) == '*' || st1.charAt(i) == st2.charAt(i)) {
                 continue;  
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    private static void dfs(int len1, int len2, int depth, String[] user_id) {
        if (depth == len2) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < len1; i++) {
                if (visited[i]) {
                    set.add(user_id[i]);
                }
            }
            for (HashSet<String> now: list) {
                if (now.equals(set)) {
                    return;
                }
            }
            list.add(set);
            return;
        }
      
        for (int i = 0; i < len1; i++) {
            if (!visited[i] && matrix[i][depth]) {
                visited[i] = true;
                dfs(len1, len2, depth + 1, user_id);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        int len1 = user_id.length;
        int len2 = banned_id.length;
        matrix = new boolean[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                matrix[i][j] = coincide(user_id[i], banned_id[j]);
            }
        }
        
        visited = new boolean[len1];
        dfs(len1, len2, 0, user_id);
        
        return list.size();
    }
}