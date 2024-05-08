/*
참고 사이트
https://velog.io/@hyeokkr/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A44%EB%8B%A8-%EA%B3%A0%EC%9D%8C-with-Java
*/
/*
k = 3단 고음의 수
f(x): x개 만큼의 3단 고음를 썼을 때의 최대 값
f(1) = 3 + 2 = 3 + 2
f(2) = f(1) * 3 + 2 = 9 + 8
f(3) = f(2) * 3 + 2 = 27 + 26
...
f(k) = f(k - 1) * 3 + 2 = 3^k + 3^k - 1
*/

class Solution {
    private int getMul(int n) {
        return (int) (Math.log(n) / Math.log(3));
    }
    
    private int dfs(int n, int mul, int p) {
        if (mul * 2 < p) return 0;
        if (n == 3 && mul == 1 && p == 0) return 1;
        if (n == 4 && mul == 1 && p == 1) return 1;
        if (n == 5 && mul == 1 && p == 2) return 1;
        
        int cnt = 0;
        for (int i = 0; i <= p; i++) {
            if ((n - i) > 0 && (n - i) % 3 == 0) {
                cnt += dfs((n - i) / 3, mul - 1, p - i);
            }
        }
        
        return cnt;
    }
    
    public int solution(int n) {
        int mul = getMul(n);
        int p = mul * 2;
        return dfs(n, mul, p);
    }
}