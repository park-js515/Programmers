import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        ArrayList<Integer> list = new ArrayList<>();
        int a = slicer[0], b = slicer[1], c = slicer[2];
        int len = num_list.length;
        
        switch (n) {
            case 1:
                for (int i = 0; i <= b; i++) {
                    list.add(num_list[i]);
                }
                break;
            case 2:
                for (int i = a; i < len; i++) {
                    list.add(num_list[i]);
                }
                break;
            case 3:
                for (int i = a; i <= b; i++) {
                    list.add(num_list[i]);
                }
                break;
            case 4:
                for (int i = a; i <= b; i += c) {
                    list.add(num_list[i]);
                }
         }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}