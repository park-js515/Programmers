import java.io.*;
class Main {
	private static int pint(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		System.out.println(pint(input[0]) + pint(input[1]));
		br.close();
	}
}