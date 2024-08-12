import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] dat = new int[502];
        for (int stage: stages) {
            dat[stage]++;
        }
        
        int user = stages.length;
        double[] falseRate = new double[N + 1];
        for (int i = 1; i <= N; i++) {
            falseRate[i] = user == 0 ? 0 : (double) dat[i] / user;
            user -= dat[i];
        }
        
        Integer[] answer = IntStream.range(1, N + 1).boxed().toArray(Integer[]::new);
        Arrays.sort(answer, (o1, o2) -> {
            if (falseRate[o1] == falseRate[o2]) {
                return Integer.compare(o1, o2);
            }
            return Double.compare(falseRate[o2], falseRate[o1]);
        });
        
        return Arrays.stream(answer).mapToInt(Integer::intValue).toArray();
    }
}