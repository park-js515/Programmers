import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>() {{
            put("code", 0);
            put("date", 1);
            put("maximum", 2);
            put("remain", 3);
        }};
        
        List<int[]> list = new ArrayList<>();
        int extIndex = map.get(ext);
        int sortIndex = map.get(sort_by);
        
        for (int[] d: data) {
            if (d[extIndex] < val_ext) {
                list.add(d);
            }
        }
        
        Collections.sort(list, (o1, o2) -> o1[sortIndex] - o2[sortIndex]);
        int size = list.size();
        int[][] answer = new int[size][4];
        for (int i = 0; i < size; i++) {
            int[] row = list.get(i);
            for (int j = 0; j < 4; j++) {
                answer[i][j] = row[j];
            }
        }
        
        return answer;
    }
}