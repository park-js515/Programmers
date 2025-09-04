import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        for (int index = 0; index < n; index++) {
            int[] command = commands[index];
            int i = command[0] - 1;
            int j = command[1];
            int k = command[2] - 1;
            
            int[] arr = Arrays.copyOfRange(array, i, j);
            Arrays.sort(arr);
            
            answer[index] = arr[k];
        }
        
        return answer;
    }
}