import java.util.ArrayDeque;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        ArrayDeque<int[]> dStack = new ArrayDeque<>();
        ArrayDeque<int[]> pStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (deliveries[i] > 0) {
                dStack.add(new int[] {i + 1, deliveries[i]});
            }
            if (pickups[i] > 0) {
                pStack.add(new int[] {i + 1, pickups[i]});
            }
        }
        
        long answer = 0;
        while (!dStack.isEmpty() || !pStack.isEmpty()) {
            int target = 0;
            int dSum = 0;
            int pSum = 0;
            while (!dStack.isEmpty()) {
                int[] pL = dStack.pollLast();
                if (dSum + pL[1] <= cap) {
                    dSum += pL[1];
                    target = Math.max(target, pL[0]);
                } else {
                    pL[1] = pL[1] + dSum - cap;
                    dStack.add(pL);
                    target = Math.max(target, pL[0]);
                    break;
                }
            }
            while (!pStack.isEmpty()) {
                int[] pL = pStack.pollLast();
                if (pSum + pL[1] <= cap) {
                    pSum += pL[1];
                    target = Math.max(target, pL[0]);
                } else {
                    pL[1] = pL[1] + pSum - cap;
                    pStack.add(pL);
                    target = Math.max(target, pL[0]);
                    break;
                }
            }
            
            answer += target * 2;
        }
        
        return answer;
    }
}