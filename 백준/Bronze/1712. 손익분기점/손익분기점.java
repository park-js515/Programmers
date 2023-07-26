import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int cost = Integer.parseInt(input[0]);
        int earn = Integer.parseInt(input[2]) - Integer.parseInt(input[1]);
        
        if (earn <= 0) {
            System.out.println(-1);
        } 
        else {
            System.out.println(cost/earn + 1);
        }
        br.close();
    }
}