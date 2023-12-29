import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    private boolean[] visited;
    private int D;
    private ArrayList<boolean[]> checkList = new ArrayList<>();
    private void dfs(int rows, int cols, String[][] relation, int depth, int start) {
        if (D == depth) {
            HashSet<ArrayList<String>> set = new HashSet<>();
            for (int i = 0; i < rows; i++) {
                ArrayList<String> list = new ArrayList<>();
                for (int j = 0; j < cols; j++) {
                    if (visited[j]) {
                        list.add(relation[i][j]);
                    }
                }
                set.add(list);
            }
            
            if (set.size() == rows) {
                boolean flag = false;
                for (boolean[] arr: checkList) {
                    int sum1 = 0;
                    int sum2 = 0;
                    int intersection = 0;
                    for (int i = 0; i < cols; i++) {
                        if (visited[i]) {
                            sum1++;
                        }
                        if (arr[i]) {
                            sum2++;
                        }
                        if (visited[i] && arr[i]) {
                            intersection++;
                        }
                    }
                    int min = Math.min(sum1, sum2);
                    
                    if (min == intersection) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    checkList.add(Arrays.copyOf(visited, cols));
                }
            }
            return;
        }
        
        for (int i = start; i < cols; i++) {
            visited[i] = true;
            dfs(rows, cols, relation, depth + 1, i + 1);
            visited[i] = false;
        }
    }
    
    public int solution(String[][] relation) {
        int rows = relation.length;
        int cols = relation[0].length;
        visited = new boolean[cols];
        
        for (int i = 1; i <= cols; i++) {
            D = i;
            dfs(rows, cols, relation, 0, 0);
        }
        
        return checkList.size();
    }
}