class Solution {
    public int solution(int n, int a, int b) {
        boolean[] tree =  new boolean[2 * n + 1];
        a += n - 1;
        b += n - 1;
        int answer = 0;
        while (a >= 1) {
            tree[a] = true;
            a /= 2;
        }
        while (b >= 1) {
            if (tree[b]) {
                break;
            }
            answer++;
            b /= 2;
        }
        
        return answer;
    }
}