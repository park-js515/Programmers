import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('S', 1);
        map.put('D', 2);
        map.put('T', 3);
        
        int[] num = new int[3];
        int[] sum = new int[3];
        List<Character>[] op = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            op[i] = new ArrayList<>();
        }
        
        int index1 = 0;
        int index2 = 0;
        
        while (index1 < dartResult.length()) {
            if (dartResult.startsWith("10", index1)) {
                num[index2] = 10;
                index1 += 2;
            } else {
                num[index2] = dartResult.charAt(index1) - '0';
                index1++;
            }
            
            while (index1 < dartResult.length() && !Character.isDigit(dartResult.charAt(index1))) {
                op[index2].add(dartResult.charAt(index1++));
            }
            index2++;
        }
        
        for (int i = 0; i < 3; i++) {
            sum[i] += (int) Math.pow(num[i], map.get(op[i].get(0)));
        }
        
        for (int i = 0; i < 3; i++) {
            if (op[i].size() == 1) continue;
            char option = op[i].get(1);
            if (option == '*') {
                if (i > 0) {
                    sum[i - 1] *= 2;
                }
                sum[i] *= 2;
            } else if (option == '#') {
                sum[i] *= -1;
            }
        }
        
        return sum[0] + sum[1] + sum[2];
    }
}