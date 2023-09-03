import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int th = 1;

        while (X - th > 0) {
            X -= th;
            th++;
        }

        int total = th + 1;

        if (th % 2 == 1)  {
            int nu = total - X;
            System.out.println(nu + "/" + X);
        }
        else
        {
            X = total - X;
            int nu = total - X;
            System.out.println(nu + "/" + X);
        }
        br.close();
    }
}