import java.io.*;

class Main {
	private static int pint(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = pint(br.readLine());
		
		point: for (int t = 0; t < T; t++) {
			String[] input = br.readLine().split(" ");
			int a = pint(input[0]);
			int[] arrA = new int[5];
			for (int i = 1; i <= a; i++) {
				arrA[pint(input[i])]++;
			}
			
			input = br.readLine().split(" ");
			int b = pint(input[0]);
			int[] arrB = new int[5];
			for (int i = 1; i <= b; i++) {
				arrB[pint(input[i])]++;
			};
			
			for (int i = 4; i >= 1; i--) {
				if (arrA[i] > arrB[i]) {
					bw.write("A\n");
					continue point;	
				} else if (arrA[i] < arrB[i]) {
					bw.write("B\n");
					continue point;
				}
			}
			
			bw.write("D\n");
		}
		
		bw.write("\n");
		bw.close();
		br.close();
	}
}