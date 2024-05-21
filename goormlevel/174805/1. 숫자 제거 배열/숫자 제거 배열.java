import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		String K = input[1];
		
		input = br.readLine().split(" ");
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (input[i].indexOf(K) == -1) {
				answer++;
			}
		}
		
		System.out.println(answer);
		br.close();
	}
}