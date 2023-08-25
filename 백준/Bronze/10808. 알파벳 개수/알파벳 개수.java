import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        int[] arr = new int[26];

        for (int i = 0; i < len; i++) {
            arr[input.charAt(i) - 'a'] += 1;
        }

        for (int i: arr) {
            System.out.print(i +" ");
        }
        br.close();
    }
}