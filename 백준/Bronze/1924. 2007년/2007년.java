import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] input = br.readLine().split(" ");

        int x = Integer.parseInt(input[0]), y = Integer.parseInt(input[1]);
        int sum = y - 1;

        for (int i = 0; i < x - 1; i++) {
            sum += months[i];
        }

        System.out.println(days[sum % 7]);
        br.close();
    }
}