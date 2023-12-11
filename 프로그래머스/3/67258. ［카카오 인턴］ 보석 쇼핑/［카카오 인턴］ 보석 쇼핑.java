import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<int[]> list = new ArrayList<>();
        int len = gems.length;
        int gemSize = set.size();
        int left = 0, right = 0;
        for (String st: set) {
            map.put(st, 0);
        }
        map.put(gems[0], 1);
        int mapSize = 1;
        
        while (true) {
            if (mapSize >= gemSize) {
                if (mapSize == gemSize) {
                    list.add(new int[] {left + 1, right + 1});
                }
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left++]) == 0) {
                    mapSize--;
                }
            } else {
                if (right + 1 < len) {
                    map.put(gems[++right], map.get(gems[right]) + 1);
                    if (map.get(gems[right]) == 1) {
                        mapSize++;
                    }
                } else {
                    break;
                }
            }
        }
        
        Collections.sort(list, (o1, o2) -> {
            int val1 = o1[1] - o1[0];
            int val2 = o2[1] - o2[0];
            if (val1 != val2) {
                return val1 - val2;
            }
            return o1[0] - o2[0];
        });
        
        return list.get(0);
    }
}