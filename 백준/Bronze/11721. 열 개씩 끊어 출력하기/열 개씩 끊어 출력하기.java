import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int len = input.length();
		int s10 = len / 10;
		int s1 = len % 10;
		
		for (int i = 0; i < s10 * 10; i += 10) {
			System.out.println(input.substring(i, i + 10));
		}

		if (s1 > 0) {
			System.out.println(input.substring(s10 * 10, s10 * 10 + s1));
		}
		
		br.close();
	}
}