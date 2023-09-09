import java.io.*;
import java.util.*;

public class Main {
	private static int pint(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = pint(input[0]), M = pint(input[1]);
		int[] arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = pint(input[0]), b = pint(input[1]);
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
		}
		br.close();
	}
}