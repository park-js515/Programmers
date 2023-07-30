import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] months = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        String[] input = br.readLine().split(" ");

        int x = Integer.parseInt(input[0]), y = Integer.parseInt(input[1]);
        int sum = y - 1;
        sum += months[x - 1];

        System.out.println(days[sum % 7]);
        br.close();
    }
}