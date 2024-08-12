import java.util.Set;
import java.util.HashSet;

class Solution {
    private int getDivisor(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                set.add(n / i);
                set.add(i);
            }
        }
        
        return set.size();
    }
    
    public int solution(int number, int limit, int power) {
        int[] divisors = new int[number];
        for (int i = 1; i <= number; i++) {
            divisors[i - 1] = getDivisor(i);
        }
        
        int answer = 0;
        for (int i = 0; i < number;i ++) {
            answer += divisors[i] > limit ? power : divisors[i];
        }
        
        return answer;
    }
}