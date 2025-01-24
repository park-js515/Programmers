import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

class Main {

    private static int getMax(HashMap<Character, Integer> map) {
        return Collections.max(map.values());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = "";
        HashMap<Character, Integer> map = new HashMap<>();

        while ((s = br.readLine()) != null) {
            for (int i = 0; i < s.length(); i++) {
                char key = s.charAt(i);
                if (key == ' ') {
                    continue;
                }
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int max = getMax(map);
        StringBuilder sb = new StringBuilder();

        for (Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                sb.append(entry.getKey());
            }
        }

        char[] charArray = sb.toString().toCharArray();
        Arrays.sort(charArray);
        bw.write(new String(charArray));

        bw.close();
        br.close();

    }
}