import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    boolean[] visited = new boolean[11];
    
    private void dfs(String order, int N, int start, int depth, StringBuilder sb) {
        if (depth >= 2) {
            String st = sb.toString();
            char[] arr = st.toCharArray();
            Arrays.sort(arr);
            st = new String(arr);
            map.put(st, map.getOrDefault(st, 0) + 1);
        }
        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                StringBuilder nextSb = new StringBuilder(sb);
                nextSb.append(order.charAt(i));
                dfs(order, N, i + 1, depth + 1, nextSb);
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            dfs(orders[i], orders[i].length(), 0, 0, new StringBuilder());
        }
        ArrayList<String>[] stringList = new ArrayList[11];
        for (int i = 0; i < 11; i++) {
            stringList[i] = new ArrayList<>();
        }
        for (String key: map.keySet()) {
            stringList[key.length()].add(key);
        }
        for (int i: course) {
            Collections.sort(stringList[i], (o1, o2) -> {
                int len1 = map.get(o1);
                int len2 = map.get(o2);                
                return len2 - len1;
            });
        }        
        
        ArrayList<String> answerList = new ArrayList<>();
        for (int i: course) {
            int len = 0;
            for (int j = 0; j < stringList[i].size(); j++) {
                String st = stringList[i].get(j);
                if (j == 0) {
                    int cnt = map.get(st);
                    if (cnt < 2) {
                        break;
                    } else {
                        len = cnt;
                        answerList.add(st);
                    }
                } else if (map.get(st) == len) {
                    answerList.add(st);
                } else {
                    break;
                }
            }
        }
        
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}