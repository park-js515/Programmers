import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 2000;
        int b = 2000;
        for (int i = 0; i < 3; i++){
            int temp = Integer.parseInt(br.readLine());
            a = Math.min(a, temp);
        }
        for (int i = 0; i < 2; i++){
            int temp = Integer.parseInt(br.readLine());
            b = Math.min(b, temp);
        }

        System.out.println(a+b-50);
        br.close();
    }
}