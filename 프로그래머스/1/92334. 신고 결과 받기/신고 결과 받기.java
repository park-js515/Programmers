import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    private Map<String, Set<String>> map = new HashMap<>();
    private Map<String, Integer> index = new HashMap<>();
    private int N;
    
    private void init(String[] id_list) {
        N = id_list.length;
        for (int i = 0; i < N; i++) {
            String id = id_list[i];
            map.put(id, new HashSet<>());
            index.put(id, i);
        }
    }
    
    private void solve(String report) {
        String[] splited = report.split(" ");
        String from = splited[0];
        String to = splited[1];
        map.get(to).add(from);
    }
    
    public int[] solution(String[] id_list, String[] report, int k) {
        init(id_list);
        for (String r: report) {
            solve(r);
        }
        
        int[] answer = new int[N];
        for (String id: map.keySet()) {
            Set<String> set = map.get(id);  
            int cnt = map.get(id).size();
            if (cnt >= k) {
                for (String from: set) {
                    answer[index.get(from)]++;
                }
            }
        }
        
        return answer;
    }
}