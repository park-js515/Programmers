import java.io.*;

class Main {
	private static int pint(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int A = pint(input[0]), B = pint(input[1]), C = pint(input[2]);
		int N = pint(input[3]);
		
		int answer = 0;
		point: for (int i = 0; i <= N; i += A) {
			for (int j = 0; j <= N; j += B) {
				for (int k = 0; k <= N; k += C) {
					if (i + j + k > N) {
						break;
					}
					if (i + j + k == N) {
						answer = 1;
						break point;
					}
				}
			}
		}
		
		System.out.println(answer);
		br.close();
	}
}