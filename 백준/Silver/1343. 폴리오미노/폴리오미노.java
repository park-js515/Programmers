import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int len = input.length();
        ArrayList<Integer> arr = new ArrayList<>();
        boolean isX = false;
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == 'X') {
                if (isX) {
                    cnt++;
                }
                else {
                    arr.add(cnt);
                    isX = true;
                    cnt = 1;
                }
            }
            else {
                if (!isX) {
                    cnt--;
                }
                else {
                    arr.add(cnt);
                    isX = false;
                    cnt = -1;
                }
            }
        }

        if (cnt != 0) {
            arr.add(cnt);
        }

        String ans = "";

        for (int num: arr) {
            if (num > 0) {
                if (num % 2 == 1) {
                    ans = "-1";
                    break;
                }
                else {
                    while (num > 0) {
                        boolean flag = true;
                        if (num >= 4) {
                            flag = false;
                            for (int i = 0; i < 4; i++) {
                                ans += "A";
                            }
                            num -= 4;
                        }
                        else if (flag && num >= 2) {
                            for (int i = 0; i < 2; i++) {
                                ans += "B";
                            }
                            num -= 2;
                        }
                    }
                }
            }
            else {
                for (int i = 0; i < -num; i++) {
                    ans += ".";
                }
            }
        }

        bw.write(ans);
        br.close();
        bw.close();
    }
}