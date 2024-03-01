// 대칭으로 넘기고 직선거리를 구한다.

import java.util.Arrays;
class Solution {
    private int L2(long x1, long y1, long x2, long y2) {
        // System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
        return (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    
    private int getRev(int axis, int val) {
        int ret = val;
        int gap = Math.abs(axis - val);
        if (axis < val) {
            ret = axis - gap;
        } else if (axis > val) {
            ret =  axis + gap;
        }
        
        return ret;
    }
    
    private int getMin(int[] arr) {
        int ret = Integer.MAX_VALUE;
        for (int val: arr) {
            ret = Math.min(ret, val);
        }

        return ret;
    }
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int len = balls.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            int x = balls[i][0];
            int y = balls[i][1];
            int[] arr = new int[4];
            arr[0] = startX != x ? L2(startX, startY, x, getRev(0, y)) : 
            startY < y ? (int) Math.pow(startY + y, 2) : (int) Math.pow(2 * n - startY - y, 2);
            arr[1] = startX != x ? L2(startX, startY, x, getRev(n, y)) : Integer.MAX_VALUE;
            arr[2] = startY != y ? L2(startX, startY, getRev(0, x), y) :
            startX < x ? (int) Math.pow(startX + x, 2) : (int) Math.pow(2 * m - startX - x, 2);
            arr[3] = startY != y ? L2(startX, startY, getRev(m, x), y) : Integer.MAX_VALUE;
            answer[i] = getMin(arr);
            System.out.println(); 
        }
        
        return answer;
    }
}