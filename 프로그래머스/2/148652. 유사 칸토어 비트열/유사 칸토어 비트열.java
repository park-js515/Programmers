// 현재 위치에서 가장 깊게 파고 들었을 때, 폐구간 안에 있다면
// 더 이상의 연산을 중지하고 4^r 제곱의 형태로 정답에 더해준다.
// 그렇지 않고 일정부분만 폐구간 안에 포함된다면 재귀를 한번 더 실행한다.

class Solution {
    private int answer = 0;
    private long[] arr;
    private void dfs(int n, int depth, long l, long r, long k) {
        int mul = n - depth;
        long end = k * arr[mul];
        long start = end - arr[mul] + 1;
        if (l <= start && end <= r) {
            answer += (int) Math.pow(4, mul);
            return;
        }
        if (end < l || start > r) {
            return;
        }
        
        long x = k * 5;
        dfs(n, depth + 1, l, r, x - 4);
        dfs(n, depth + 1, l, r, x - 3);
        dfs(n, depth + 1, l, r, x - 1);
        dfs(n, depth + 1, l, r, x);
    }
    
    public int solution(int n, long l, long r) {
        arr = new long[n + 1];
        long k = 1;
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            k *= 5;
            arr[i] = k;
        }
        
        dfs(n, 0, l, r, 1);
        return answer;
    }
}