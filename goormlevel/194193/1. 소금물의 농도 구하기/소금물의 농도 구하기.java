import java.io.*;
class Main {
	private static double pd(String s) {
		return Double.parseDouble(s);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		double N = pd(input[0]), M = pd(input[1]);
		double x = N * 0.07;
		
		double answer = Math.floor(x / (N + M) * 10000) / 100;
		System.out.printf("%.2f", answer);
	}
}