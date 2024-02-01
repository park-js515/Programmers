import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private ArrayList<Integer>[][][][] list;
    
    private void save(int[] arr, int[] target, int depth) {
        if (depth == 4) {
            list[target[0]][target[1]][target[2]][target[3]].add(arr[4]);
            return;
        }
        
        if (arr[depth] != 3) {
            target[depth] = 3;
            save(arr, target, depth + 1);
        }
        target[depth] = arr[depth];
        save(arr, target, depth + 1);
    }
    
    private int find(int[] arr, int[][][][] len) {
        int start = 0;
        int end = len[arr[0]][arr[1]][arr[2]][arr[3]];
        
        while (start < end) {
            int mid = (start + end) / 2;
            if (list[arr[0]][arr[1]][arr[2]][arr[3]].get(mid) < arr[4]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return len[arr[0]][arr[1]][arr[2]][arr[3]] - start;
    }
    
    public int[] solution(String[] info, String[] query) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("cpp", 0);
        map.put("java", 1);
        map.put("python", 2);
        map.put("backend", 0);
        map.put("frontend", 1);
        map.put("junior", 0);
        map.put("senior", 1);
        map.put("chicken", 0);
        map.put("pizza", 1);
        map.put("-", 3);
        
        list = new ArrayList[4][4][4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        list[i][j][k][l] = new ArrayList<>();
                    }
                }
            }
        }
        int[][][][] len = new int[4][4][4][4];
        
        for (String st: info) {
            String[] splited = st.split(" ");
            int[] arr = new int[5];
            for (int i = 0; i < 4; i++) {
                arr[i] = map.get(splited[i]);
            }
            arr[4] = Integer.parseInt(splited[4]);
            save(arr, new int[4], 0);
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        Collections.sort(list[i][j][k][l]);
                        len[i][j][k][l] = list[i][j][k][l].size();
                    }
                }
            }
        }
        
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String q = query[i].replace("and ", "");
            String[] splited = q.split(" ");
            int[] arr = new int[5];
            for (int j = 0; j < 4; j++) {
                arr[j] = map.get(splited[j]);
            }
            arr[4] = Integer.parseInt(splited[4]);
            answer[i] = find(arr, len);
            // System.out.println(list[arr[0]][arr[1]][arr[2]][arr[3]]);
        }
        
        
        return answer;
    }
}