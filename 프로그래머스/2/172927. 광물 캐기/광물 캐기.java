import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int len = minerals.length;
        int unit = (int)Math.ceil((float)len / 5);
        int[][] arr = new int[unit][3];
        HashMap<String, Integer> map = new HashMap<>();
        map.put("diamond", 0);
        map.put("iron", 1);
        map.put("stone", 2);
        
        int[][] M = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        int[] Minerals = new int[len];
        for (int i = 0; i < len; i++) {
            Minerals[i] = map.get(minerals[i]);
        }
        
        for (int i = 0; i < unit; i++) {
            for (int j = i * 5; j < Math.min((i + 1) * 5, len); j++) {
                for (int k = 0; k < 3; k++) {
                    arr[i][k] += M[k][Minerals[j]];
                }
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return -o1[2] + o2[2];
        });
        
        int pickLen = 0;
        for (int i: picks) {
            pickLen += i;
        }
        for (int i = 0; i < Math.min(pickLen, unit); i++) {
            pq.add(arr[i]);
        }
        
        int answer = 0;
        point: for (int i = 0; i < 3; i++) {
            for (int j = 0; j < picks[i]; j++) {
                if (pq.isEmpty()) {
                    break point;
                }
                answer += pq.poll()[i];
            }
        }

        return answer;
    }
}