import java.util.stream.IntStream;

class Solution {
    public int[] solution(int start_num, int end_num) {
        return IntStream.rangeClosed(end_num, start_num)
            .map(i -> start_num + end_num - i).toArray();
    }
}