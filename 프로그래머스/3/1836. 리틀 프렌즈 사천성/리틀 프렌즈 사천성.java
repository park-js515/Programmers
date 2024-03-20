import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    private char[][] arr;
    private ArrayList<Character> alp = new ArrayList<>();
    private HashMap<Character, HashSet<HashSet<Character>>> parents = new HashMap<>();
    
    private HashSet<HashSet<Character>> getParents(char target, int[] start, int[] end) {
        int r1 = Math.min(start[0], end[0]);
        int r2 = Math.max(start[0], end[0]);
        int c1 = Math.min(start[1], end[1]);
        int c2 = Math.max(start[1], end[1]);
        HashSet<HashSet<Character>> set = new HashSet<>();
        HashSet<Character> set11 = new HashSet<>();
        HashSet<Character> set22 = new HashSet<>();
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character> set3 = new HashSet<>();
        HashSet<Character> set4 = new HashSet<>();
        
        for (int i = r1; i <= r2; i++) {
            set1.add(arr[i][c1]);
            set3.add(arr[i][c2]);
        }
        for (int i = c1; i <= c2; i++) {
            set2.add(arr[r2][i]);
            set4.add(arr[r1][i]);
        }
        if (start[0] == end[0] || start[1] == end[1]) {
            set11.addAll(set1);
            set11.addAll(set2);
            set11.addAll(set3);
            set11.addAll(set4);
            set22.add('*');
        } else if (start[1] < end[1]) {
            set11.addAll(set1);
            set11.addAll(set2);
            set22.addAll(set3);
            set22.addAll(set4);
        } else {
            set11.addAll(set2);
            set11.addAll(set3);
            set22.addAll(set1);
            set22.addAll(set4);
        };
        set11.remove('.');
        set11.remove(target);
        set22.remove('.');
        set22.remove(target);
        
        if (!set11.contains('*')) {
            set.add(set11);
        }
        if (!set22.contains('*')) {
            set.add(set22);
        }
        
        return set;
    }
    
    private String answer = "IMPOSSIBLE";
    private boolean[] visited = new boolean[200];
    private void getAnswer(int len, int depth, String st) {
        int cnt = 0;
        
        while (alp.size() > 0) {
            boolean flag = true;
            point1: for (int i = 0; i < alp.size(); i++) {
                char ch = alp.get(i);
                point2: for (HashSet<Character> set: parents.get(ch)) {
                    for (char c: set) {
                        if (!visited[(int) c]) {
                            continue point2;
                        }
                    }
                    cnt++;
                    flag = false;
                    visited[(int) alp.get(i)] = true;
                    st += alp.remove(i);
                    break point1;
                }
            }
            
            if (flag || cnt == len) {
                break;
            }
        }
        
        if (cnt == len) {
            answer = st;
        }
    }
    
    public String solution(int m, int n, String[] board) {
        arr = new char[m][n];
        HashMap<Character, ArrayList<int[]>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board[i].charAt(j);
                arr[i][j] = ch;
                if (ch < 'A' || ch > 'Z') continue;
                if (!map.containsKey(ch)) {
                    map.put(ch, new ArrayList<>());
                    alp.add(ch);
                }
                map.get(ch).add(new int[] {i, j});
            }
        }
        
        Collections.sort(alp);
        for (char key: alp) {
            Collections.sort(map.get(key), (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[0] - o2[0];
            });
        }
        for (char key: alp) {
            HashSet<HashSet<Character>> temp = getParents(key, map.get(key).get(0), map.get(key).get(1));
            if (temp.size() == 0) {
                return answer;
            }
            parents.put(key, temp);
        }
        int len = alp.size();
        getAnswer(len, 0, "");
        
        return answer;
    }
}