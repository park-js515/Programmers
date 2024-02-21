// 시간을 core로 나누면 해당 core가 몇 번 수행되었는지 알 수 있다.
// pq로 풀면 시간초과, 이분탐색으로 시간을 찾고, n에 대응되는 인덱스를 찾는다.

class Solution {
    private int getTime(int n, int[] cores, int s, int e) {
        while (s < e) {
            int m = (s + e) / 2;
            int sum = 0;
            for (int core: cores) {
                sum += m / core;
            }
            
            if (sum >= n) {
                e = m;
            } else {
                s = m + 1; 
            }
        }
        
        return s;
    }
    
    public int solution(int n, int[] cores) {
        int len = cores.length;
        n -= len;
        if (n < 0) {
            return n + len;
        }
        
        int answer = 0;
        int time = getTime(n, cores, 1,  ((n * 10000) / len) + 1);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (time - 1) / cores[i];
        }
        for (int i = 0; i < len; i++) {
            sum += (time / cores[i]) - ((time - 1) / cores[i]);
            if (sum == n) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
}