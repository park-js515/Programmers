import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

class Solution {
    private int[][] table = new int[51][51];
    private int idx = 0;
    private HashMap<Integer, String> map1 = new HashMap<>();
    private HashMap<Integer, HashSet<int[]>> map2 = new HashMap<>(); 
    private ArrayList<String> answer = new ArrayList<>();
    
    private int pint(String s) {
        return Integer.parseInt(s);
    }
    
    private void update(String s) {
        String[] splited = s.split(" ");
        int len = splited.length;
        if (len == 4) {
            int r = pint(splited[1]), c = pint(splited[2]);
            String value = splited[3];
            int index = table[r][c];
            map1.put(index, value);
        } else {
            String value1 = splited[1], value2 = splited[2];
            for (int key: map1.keySet()) {
                if (map1.get(key).equals(value1)) {
                    map1.put(key, value2);
                }
            }
        }
    }
    
    private void merge(String s) {
        String[] splited = s.split(" ");
        int r1 = pint(splited[1]), c1 = pint(splited[2]);
        int r2 = pint(splited[3]), c2 = pint(splited[4]);
        int index1 = table[r1][c1], index2 = table[r2][c2];
        if (index1 == index2) {
            return;
        }
        String v1 = map1.get(index1), v2 = map1.get(index2);
        boolean b1 = v1.equals("EMPTY");
        boolean b2 = v2.equals("EMPTY");
        if (!b1 && b2) {
            for (int[] node: map2.get(index2)) {
                table[node[0]][node[1]] = index1;
                map2.get(index1).add(node);
            }
            map1.remove(index2);
            map2.remove(index2);
        } else if (b1 && !b2) {
            for (int[] node: map2.get(index1)) {
                table[node[0]][node[1]] = index2;
                map2.get(index2).add(node);
            }
            map1.remove(index1);
            map2.remove(index1);
        } else {
            for (int[] node: map2.get(index2)) {
                table[node[0]][node[1]] = index1;
                map2.get(index1).add(node);
            }
            map1.remove(index2);
            map2.remove(index2);
        }
    }
    
    private void unmerge(String s) {
        String[] splited = s.split(" ");
        int r = pint(splited[1]), c = pint(splited[2]);
        int index = table[r][c];
        String value = map1.get(index);
        
        for (int[] node: map2.get(index)) {
            int next = (node[0] - 1) * 50 + node[1] - 1;
            table[node[0]][node[1]] = next;
            map1.put(next, "EMPTY");
            map2.put(next, new HashSet<>());
            map2.get(next).add(node);
        }

        map1.put(table[r][c], value);
        map2.put(table[r][c], new HashSet<>());
        map2.get(table[r][c]).add(new int[] {r, c});
    }
    
    private void print(String s) {
        String[] splited = s.split(" ");
        int r = pint(splited[1]), c = pint(splited[2]);
        int index = table[r][c];
        answer.add(map1.get(index));
    }
    
    public String[] solution(String[] commands) {
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                table[i][j] = idx;
                map1.put(idx, "EMPTY");
                map2.put(idx, new HashSet<>());
                map2.get(idx).add(new int[] {i, j});
                idx++;
            }
        }
        
        for (String command: commands) {
            String c = command.split(" ")[0];
            if (c.equals("UPDATE")) {
                update(command);
            } else if(c.equals("MERGE")) {
                merge(command);
            } else if(c.equals("UNMERGE")) {
                unmerge(command);
            } else {
                print(command);
            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
}