import java.io.*;
class Main {
	private static double pd(String s) {
		return Double.parseDouble(s);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		double a = pd(input[0]), b = pd(input[1]);
		System.out.printf("%.6f", a + b);
		br.close();
	}
}