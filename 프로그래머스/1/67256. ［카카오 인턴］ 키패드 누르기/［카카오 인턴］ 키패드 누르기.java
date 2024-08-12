import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private final int[][] pad = {
        {3, 1}, 
        {0, 0}, {0, 1}, {0, 2},
        {1, 0}, {1, 1}, {1, 2},
        {2, 0}, {2, 1}, {2, 2}
    };
    
    private final List<Integer> lh = new ArrayList<>(Arrays.asList(1, 4, 7));
    private final List<Integer> rh = new ArrayList<>(Arrays.asList(3, 6, 9));
    private int[] left = {3, 0};
    private int[] right = {3, 2};
    
    private int L1(int[] v1, int[] v2) {
        return Math.abs(v1[0] - v2[0]) + Math.abs(v1[1] - v2[1]);
    }
    
    private char solve(int n, String hand) {
        if (lh.contains(n)) {
            left = pad[n];
            return 'L';
        }
        if (rh.contains(n)) {
            right = pad[n];
            return 'R';
        }
        
        int d1 = L1(left, pad[n]);
        int d2 = L1(right, pad[n]);
        
        if (d1 == d2) {
            if (hand.equals("right")) {
                right = pad[n];
                return 'R';
            } else {
                left = pad[n];
                return 'L';
            }
        } else {
            if (d1 < d2) {
                left = pad[n];
                return 'L';
            } else {
                right = pad[n];
                return 'R';
            }
        }
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        for (int number: numbers) {
            sb.append(solve(number, hand));
        }
        
        return sb.toString();
    }
}