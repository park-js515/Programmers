import java.io.*;

class Main {
	private static int L1(int rs ,int rc, int es, int ec) {
		return Math.abs(rs - es) + Math.abs(rc - ec);
	}
	
	private static int pint(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = pint(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String[] input = br.readLine().split(" ");
			int X = pint(input[0]), Y = pint(input[1]), N = pint(input[2]);
			int dist = L1(X, Y, 0, 0);
			
			if (dist > N) {
				System.out.println("NO");
			} else if ((N - dist) % 2 == 1) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
		
		br.close();
	}
}