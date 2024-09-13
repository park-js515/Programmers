import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i] * 2; j++) {
                    stack.add(arr[i]);
                }
            } else {
                for (int j = 0; j < arr[i]; j++) {
                    stack.pollLast();
                }
            }
        }
        
        int size = stack.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = stack.poll();
        }
        
        return answer;
    }
}