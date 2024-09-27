import java.util.*;

class Solution {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
    
    public int solution(int balls, int share) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = balls; i > balls - share; i--) {
            list.add(i);
        }

        point: for (int i = 2; i <= share; i++) {
            int val1 = i;
            for (int j = 0; j < list.size(); j++) {
                if (val1 == 1) continue point;
                int val2 = list.get(j);
                if (val2 == 1) continue;
                
                int g = gcd(val1, val2);
                val1 /= g;
                val2 /= g;
                list.set(j, val2);
            }
        }
        
        int answer = 1;
        for (int i : list) answer *= i;
        return answer;
    }
}