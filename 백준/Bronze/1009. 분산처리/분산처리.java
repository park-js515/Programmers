import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
			int val = 1;
			
			for (int i = 0; i < b; i++) {
				val = val * a % 10;
			}
			
			System.out.println(val == 0 ? 10 : val);
		}
		
		br.close();
	}
}