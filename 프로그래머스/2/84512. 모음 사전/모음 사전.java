class Solution {
    private static int idx = 0;
    private static boolean findAnswer = false;
    private static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    private static void dfs(String word, StringBuilder sb, int depth) {
        if (depth > 5 || findAnswer) return;
        if (depth > 0) {
            idx++;
            String st = sb.toString();
            if (st.equals(word)) {
                findAnswer = true;
                return;
            }
        }
        for (int i = 0; i < 5; i++) {
            StringBuilder nextSb = new StringBuilder(sb);
            dfs(word, nextSb.append(vowels[i]), depth + 1);
        }
    }
    public int solution(String word) {
        dfs(word, new StringBuilder(), 0);
        return idx;
    }
}