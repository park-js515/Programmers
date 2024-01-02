import java.util.ArrayList;

class Solution {
    private ArrayList<Integer> getList(int k) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(k);
        
        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = (k * 3) + 1;
            }
            list.add(k);
        }
        
        return list;
    }
    
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Integer> list = getList(k);
        int n = list.size() - 1;
        double[] area = new double[n];
        double[] prefixed = new double[n + 1];
        for (int i = 0; i < n; i++) {
            area[i] = ((double)list.get(i) + list.get(i + 1)) / 2;
        }
        for (int i = 1; i < n + 1; i++) {
            prefixed[i] = prefixed[i - 1] + area[i - 1];
        }
        
        int len = ranges.length;
        double[] answer = new double[len];
        for (int i = 0; i < len; i++) {
            int left = ranges[i][0];
            int right = n + ranges[i][1];
            if (left <= right && right <= n) {
                answer[i] = prefixed[right] - prefixed[left];
            } else {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}