import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, int[]> map = new HashMap<>();
        int idx = k;
        for (int i = 1; i < n - 1; i++) {
            map.put(i, new int[] {i - 1, i + 1});
        }
        map.put(0, new int[] {-1, 1});
        map.put(n - 1, new int[] {n - 2, -1});
        
        for (String st: cmd) {
            if (st.length() == 1) {
                String direction = st;
                if (direction.equals("C")) {
                    int[] current = map.get(idx);
                    stack.add(idx);
                    if (current[0] != -1) {
                        map.get(current[0])[1] = current[1];
                    }
                    if (current[1] != -1) {
                        map.get(current[1])[0] = current[0];
                        idx = current[1];
                    } else {
                        idx = current[0];
                    }
                } else {
                    int temp = stack.pollLast();
                    int[] current = map.get(temp);
                    if (current[0] != -1) {
                        map.get(current[0])[1] = temp;
                    }
                    if (current[1] != -1) {
                        map.get(current[1])[0] = temp;
                    }
                }
            } else {
                String[] splited = st.split(" ");
                String direction = splited[0];
                int mv = Integer.parseInt(splited[1]);
                if (direction.equals("U")) {
                    for (int i = 0; i < mv; i++) {
                        idx = map.get(idx)[0];
                    }
                } else {
                    for (int i = 0; i < mv; i++) {
                        idx = map.get(idx)[1];
                    }
                }
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append('O');
        }
        for (int s: stack) {
            answer.setCharAt(s, 'X');
        }
        return answer.toString();
    }
}