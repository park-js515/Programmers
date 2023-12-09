import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] sequence, int k) {
        ArrayList<int[]> list = new ArrayList<>();
        int len = sequence.length;
        int left = 0, right = 0;
        int sum = sequence[0];
        while (true) {
            if (sum > k) {
                sum -= sequence[left++];
            } else if (sum < k) {
                if (++right < len) {
                    sum += sequence[right];
                } else {
                    break;
                }
            } else {
                list.add(new int[] {left, right});
                sum -= sequence[left++];
            }
        }
        
        Collections.sort(list, (o1, o2) -> {
            int gap = (o1[1] - o1[0]) - (o2[1] - o2[0]);
            if (gap != 0) {
                return gap;
            } else {
                return o1[0] - o2[0];
            }
        });
        
        return list.get(0);
    }
}