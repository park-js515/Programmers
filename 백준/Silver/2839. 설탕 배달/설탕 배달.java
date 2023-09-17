import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][2];
		arr[3][0] = 1;
		if (N >= 5) {			
			arr[5][1] = 1;
		}
		
		for (int i = 0; i <= N - 3; i++) {			
			int sum1 = arr[i][0] + arr[i][1];
			if (sum1 == 0) continue;
			int sum2 = arr[i + 3][0] + arr[i + 3][1];
			
			if (sum2 == 0 || sum1 + 1 < sum2) {
				arr[i + 3][0] = arr[i][0] + 1;
				arr[i + 3][1] = arr[i][1];
			}
		}
		
		for (int i = 0; i <= N - 5; i++) {
			int sum1 = arr[i][0] + arr[i][1];
			if (sum1 == 0) continue;
			int sum2 = arr[i + 5][0] + arr[i + 5][1];
			
			if (sum2 == 0 || sum1 + 1 < sum2) {
				arr[i + 5][0] = arr[i][0];
				arr[i + 5][1] = arr[i][1] + 1;
			}
		}
		
		for (int i = 0; i <= N - 3; i++) {			
			int sum1 = arr[i][0] + arr[i][1];
			if (sum1 == 0) continue;
			int sum2 = arr[i + 3][0] + arr[i + 3][1];
			
			if (sum2 == 0 || sum1 + 1 < sum2) {
				arr[i + 3][0] = arr[i][0] + 1;
				arr[i + 3][1] = arr[i][1];
			}
		}
		
		
		if (arr[N][0] * 3 + arr[N][1] * 5 != N) {
			System.out.println(-1);
		}
		else {
			System.out.println(arr[N][0] + arr[N][1]);
		}
		
		br.close();
	}
}