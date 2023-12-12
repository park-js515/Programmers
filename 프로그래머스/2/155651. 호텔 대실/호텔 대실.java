import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    private static int getMinute(String time) {
        String[] splited = time.split(":");
        
        return Integer.parseInt(splited[0]) * 60 + Integer.parseInt(splited[1]);
    }
    public int solution(String[][] book_time) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[][] book_time_arr = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            book_time_arr[i][0] = getMinute(book_time[i][0]);
            book_time_arr[i][1] = getMinute(book_time[i][1]) + 10;
        }
        Arrays.sort(book_time_arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        int now = 0;
        int answer = 0;
        for (int[] t: book_time_arr) {
            while (!pq.isEmpty()) {
                if (t[0] >= pq.peek()[1]) {
                    pq.poll();
                } else {
                    break;
                }
            }
            pq.add(t);
            if (answer < pq.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}