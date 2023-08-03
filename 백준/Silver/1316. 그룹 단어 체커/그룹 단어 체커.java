import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            String st = br.readLine();
            int len = st.length();

            boolean[] dat = new boolean[200];
            int idx = 1;
            char c = st.charAt(0);
            dat[c] = true;
            boolean check = true;

            while (idx < len) {
                char now = st.charAt(idx);

                if (c != now) {
                    if (dat[now]) {
                        check = false;
                        break;
                    }
                    else {
                        dat[now] = true;
                        c = now;
                    }
                }
                idx++;
            }

            if (check) {
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}