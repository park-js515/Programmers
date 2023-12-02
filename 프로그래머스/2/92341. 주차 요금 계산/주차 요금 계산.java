import java.util.ArrayList;

class Solution {
    private static int getIntegerTime(String st) {
        String[] splited = st.split(":");
        int hour = Integer.parseInt(splited[0]);
        int minute = Integer.parseInt(splited[1]);
        return hour * 60 + minute;
    }
    public int[] solution(int[] fees, String[] records) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] times = new int[10000];
        int[] prefixedTime = new int[10000];
        char[] state = new char[10000];
        
        for (String record: records) {
            String[] splited = record.split(" ");
            int time = getIntegerTime(splited[0]);
            int carNum = Integer.parseInt(splited[1]);
            boolean isIn = splited[2].equals("IN");
            
            if (isIn) {
                times[carNum] = time;
                state[carNum] = 'I';
            } else {
                state[carNum] = 'O';
                prefixedTime[carNum] += time - times[carNum];
            }
        }
        
        for (int i = 0; i < 10000; i++) {
            if (state[i] == 'I') {
                state[i] = 'O';
                prefixedTime[i] += 1439 - times[i];            
            }
        }
        
        for (int i = 0; i < 10000; i++) {
            if (prefixedTime[i] > 0) {
                if (prefixedTime[i] <= fees[0]) {
                    list.add(fees[1]);
                } else {
                    int Q = (prefixedTime[i] - fees[0]) / fees[2];
                    if ((prefixedTime[i] - fees[0]) % fees[2] != 0) Q++;
                    list.add(fees[1] + Q * fees[3]);
                }
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}