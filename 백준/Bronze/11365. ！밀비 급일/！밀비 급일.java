import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
		String input = br.readLine();
		
		if (input.equals("END")) {
			break;
		}
		
		int N = input.length();
		for (int i = N - 1; i >= 0; i--) {
			bw.write(input.charAt(i));
		}
		bw.write("\n");
		}
		
		bw.close();
		br.close();
	}
}