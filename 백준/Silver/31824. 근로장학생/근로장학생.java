import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = pint(input[0]), M = pint(input[1]);
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                for (int k = j + 1; k <= s.length(); k++) {
                    String sub = s.substring(j, k);
                    if (map.containsKey(sub)) {
                        sb.append(map.get(sub));
                    }
                }
            }

            if (sb.length() != 0) {
                System.out.println(sb);
            } else {
                System.out.println(-1);
            }
        }

        br.close();
    }
}