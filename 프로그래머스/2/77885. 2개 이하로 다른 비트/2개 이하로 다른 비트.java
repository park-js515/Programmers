// 수학적으로 고심해야하는 문제
// 좋은 문제인데, 생각하기에 너무 어렵다.
// dfs에 빠져서 생각이 좀 많이 굳은 문제였던 거 같음.
class Solution {    
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String bin = Long.toString(numbers[i], 2);
                long find0 = -1;
                for (int j = bin.length() - 1; j >= 0; j--) {
                    if (bin.charAt(j) == '0') {
                        find0 = bin.length() - 1 - j;
                        break;
                    }
                }
                if (find0 == -1) {
                    find0 = bin.length();
                }
                find0 = (long)Math.pow(2, find0);
                answer[i] = numbers[i] + find0 - find0 / 2;
            }
        }
        return answer;
    }
}