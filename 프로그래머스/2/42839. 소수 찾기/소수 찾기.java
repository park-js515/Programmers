class Solution {
    private static int answer = 0;
    private static boolean[] visited = new boolean[10000000];
    private static boolean[] primeVisited = new boolean[10000000];
    private static boolean[] primeArr = getPrimeArr(10000000);
    private static boolean[] getPrimeArr(int N) {
        boolean[] arr = new boolean[N + 1];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i <= (int)Math.sqrt(N) + 1; i++) {
            if (!arr[i]) {
                for (int j = i * 2; j < N + 1; j += i) {
                    arr[j] = true;
                }
            }
        }
        
        return arr;
    }
    private static void dfs(int N, String numbers, StringBuilder sb) {
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                StringBuilder nextSb = new StringBuilder(sb);
                nextSb.append(numbers.charAt(i));
                int val = Integer.parseInt(nextSb.toString());
                if (!primeArr[val] && !primeVisited[val]) {
                    primeVisited[val] = true;
                    answer++;
                }
                dfs(N, numbers, nextSb);
                visited[i] = false;
            }
        }
    }
    public int solution(String numbers) {
        dfs(numbers.length(), numbers, new StringBuilder());
        return answer;
    }
}