import java.util.Arrays;

class Solution {
    private int len;
    private int distance;
    private int n;
    private int[] rocks;
    
    private int binarySearch() {
        int left = 1;
        int right = distance;
        
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = check(mid);
            // System.out.println(mid + " " + cnt + " " + left + " " + right);
            if (cnt <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private int check(int interval) {
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        
        int current = 0;
        for (int i = 0; i < len; i++) {
            if (rocks[i] - current >= interval) {
                min = Math.min(min, rocks[i] - current);
                current = rocks[i];
            } else {
                cnt++;
            }
        }
        
        if (distance - current < interval) {
            cnt++;
        }
        
        return cnt;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        this.len = rocks.length;
        this.distance = distance;
        this.n = n;
        this.rocks = rocks;
        
//         for (int i = 0; i <= distance; i++) {
//             System.out.println(i + " " + check(i));
//         }
//         System.out.println("----");
        
        return binarySearch();
    }
}