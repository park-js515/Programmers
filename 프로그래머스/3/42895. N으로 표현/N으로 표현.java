import java.util.HashSet;

class Solution {
    public int solution(int N, int number) {
        HashSet<Integer>[] set = new HashSet[9];
        for (int i = 1; i < 9; i++) {
            set[i] = new HashSet<>();
        }
        
        int answer = -1;
        int t = 0;
        point: for (int i = 1; i < 9; i++) {
            t = (t * 10) + N;
            set[i].add(t);
            for (int j = 1; j < i; j++) {
                for (int a: set[j]) {
                    for (int b: set[i - j]) {
                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(a * b);
                        if (b != 0) {
                            set[i].add(a / b);
                        }
                    }
                }
            }
            
            if (set[i].contains(number)) {
                answer = i;
                break point;
            }
        }
        
        return answer;
    }
}