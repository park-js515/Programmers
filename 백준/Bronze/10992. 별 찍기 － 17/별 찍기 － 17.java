import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		if (N > 1) {
			for (int i = 1; i < N; i++) {
				bw.write(" ");
			}
			bw.write("*\n");
			
			for (int i = N - 2; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					bw.write(" ");
				}
				bw.write("*");
				
				for (int j = 0; j < (N - 2 - i) * 2 + 1; j++) {
					bw.write(" ");
				}
				
				bw.write("*\n");
			}
			
		}
		
		for (int i = 0; i < 2 * (N - 1) + 1; i++) {
			bw.write("*");
		}
		
		bw.close();
		br.close();
	}
}