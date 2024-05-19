import java.io.*;
import java.util.*;

class Main {
	private static int pint(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] numberString = br.readLine().split(" ");
		int n = pint(input);
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = pint(numberString[i]);
		}
		
		Set<Integer> set = new HashSet<>();
		for (int num: numbers) {
			if (set.contains(-num)) {
				set.remove(-num);
			} else {
				set.add(num);
			}
		}
		
		int answer = 0;
		for (int a: set) {
			answer += a;
		}
		
		System.out.println(answer);
		br.close();
	}
}