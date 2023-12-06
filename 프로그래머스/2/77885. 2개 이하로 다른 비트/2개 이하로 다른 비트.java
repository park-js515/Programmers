// 짝수 0으로 끝나므로 1만 더해주면 된다.
// 홀수의 경우 01이 되는 경우를 10으로 바꿔주면 된다.
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int cnt = 0;
            long num = numbers[i];
            while (num % 2 == 1) {
                num /= 2;
                cnt++;
            }
            answer[i] = cnt == 0 ? numbers[i] + 1 : numbers[i] + (long)Math.pow(2, cnt - 1);
            
        }
        return answer;
    }
}