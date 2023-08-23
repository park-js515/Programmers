import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] alp = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
        String dz = "dz=";
        String input = br.readLine();
        int N = input.length();
        int idx = 0;
        int cnt = 0;

        point: while (idx < N) {
            if (idx + 2 < N) {
                String temp =  input.substring(idx, idx + 3);
                if (temp.equals(dz)) {
                    cnt++;
                    idx += 3;
                    continue point;
                }
            }

            if (idx + 1 < N) {
                String temp = input.substring(idx, idx + 2);
                for (String st: alp) {
                    if (temp.equals(st)) {
                        cnt++;
                        idx += 2;
                        continue point;
                    }
                }

                cnt++;
                idx++;
            }
            else {
                cnt++;
                idx++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}