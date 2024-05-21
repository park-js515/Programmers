import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = Integer.parseInt(input);
		int[] arr = {40, 20, 10, 5, 1};
		
		int answer = 0;
		for (int i: arr) {
			answer += N / i;
			N %= i;
		}
		
		System.out.println(answer);
		br.close();
	}
}