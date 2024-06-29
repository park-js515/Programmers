import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static int L, C;
    private static char[] arr;
    private static boolean[] isVowel;
    private static final Character[] vowel = {'a', 'e', 'i', 'o', 'u'};
    private static char[] password;
    private static BufferedWriter bw;

    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    private static void init(BufferedReader br) throws IOException {
        String[] split = br.readLine().split(" ");
        L = pint(split[0]);
        C = pint(split[1]);

        arr = new char[C];
        isVowel = new boolean[C];
        password = new char[L];

        split = br.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            arr[i] = split[i].charAt(0);
        }

        Arrays.sort(arr);

        Set<Character> vovelSet = new HashSet<>(Arrays.asList(vowel));
        for (int i = 0; i < C; i++) {
            isVowel[i] = vovelSet.contains(arr[i]);
        }
    }

    private static void dfs(int depth, int start, int a, int b) throws IOException {
        if (depth == L) {
            if (a >= 1 && b >= 2) {
                bw.write(new String(password) + "\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            password[depth] = arr[i];
            if (isVowel[i]) {
                dfs(depth + 1, i + 1, a + 1, b);
            } else {
                dfs(depth + 1, i + 1, a, b + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init(br);
        dfs(0, 0, 0, 0);

        bw.close();
        br.close();
    }
}