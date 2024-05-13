import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[] {-1};
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }    
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                list.add(arr[i]);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}