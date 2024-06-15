class Solution {
    
    private boolean check(int[] food_times, long k) {
        long sum = 0;
        for (int f: food_times) {
            sum += f;
        }
        
        return sum > k;
    }
    
    private int getMax(int[] food_times) {
        int max = 0;
        for (int f: food_times) {
            max = Math.max(max, f);
        }
        
        return max;
    }

    private int getLowerBound(int[] food_times, long k) {
        int left = 1;
        int right = getMax(food_times);
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            long sum = 0;
            for (int f: food_times) {
                sum += Math.min(f, mid);
            }
            
            if (sum < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    public int solution(int[] food_times, long k) {
        int answer = -1;
        if (check(food_times, k) == false) {
            return answer;
        }
        
        int lb = getLowerBound(food_times, k);
        long sum = 0;
        
        for (int i = 0; i < food_times.length; i++) {
            int value = Math.min(lb - 1, food_times[i]);
            sum += value;
            food_times[i] -= value;
        }
        
        point: for (int t = 0; t < 2; t++) {
            for (int i = 0; i < food_times.length; i++) {
                if (food_times[i] > 0) {
                    if (++sum > k) {
                        answer = i + 1;
                        break point;
                    }
                }
            }
        }
        
        return answer;
    }
}