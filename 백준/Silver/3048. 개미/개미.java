import java.io.*;

public class Main {
    private static int pint(String s) {
        return Integer.parseInt(s);
    }

    private static void SW(int len, char[][] arr) {
        for (int i = 0; i < len - 1; i++) {
            if (arr[i][1] == 'r' && arr[i + 1][1] == 'l') {
                char temp1 = arr[i][0];
                char temp2 = arr[i][1];

                arr[i][0] = arr[i + 1][0];
                arr[i][1] = arr[i + 1][1];
                arr[i + 1][0] = temp1;
                arr[i + 1][1] = temp2;
                i++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N1 =  pint(input[0]), N2 = pint(input[1]);
        char[][] grp = new char[N1 + N2][2];
        String temp = br.readLine();
        for (int i = 0; i < N1; i++) {
            grp[N1 - i - 1][0] = temp.charAt(i);
            grp[i][1] = 'r';
        }
        temp = br.readLine();
        for (int i = N1; i < N1 + N2; i++) {
            grp[i][0] = temp.charAt(i - N1);
            grp[i][1] = 'l';
        }
        int T = pint(br.readLine());
        int len = N1 + N2;

        for (int t = 0; t < T; t++) {
            SW(len, grp);
        }

        for (int i = 0; i < len; i++) {
            bw.write("" + grp[i][0]);
        }
        br.close();
        bw.close();
    }
}