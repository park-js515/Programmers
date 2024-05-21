import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int gap = 'a' - 'A';
		for (int i = 0; i < N; i++) {
			char ch = input.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				ch = (char) (ch + gap);
			} else {
				ch = (char) (ch - gap);
			}
			
			sb.append(ch);
		}
		
		System.out.println(sb);
		br.close();
	}
}