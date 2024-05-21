import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =  Integer.parseInt(br.readLine());
		int MOD = 1_000_000_007;
		long answer = 1;
		
		for (int i = 1; i <= N; i++) {
			answer *= i;
			answer %= MOD;
		}
		
		System.out.println(answer);
		br.close();
	}
}