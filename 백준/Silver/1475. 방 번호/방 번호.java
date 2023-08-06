import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int size = input.length();
		int[] dat = new int[200];
		
		for (int i = 0; i < size; i++) {
			dat[input.charAt(i)]++;
		}
		
		int MAX = 0;
		int check = 0;
		check = (dat['6'] + dat['9']) % 2 == 0 ? (dat['6'] + dat['9']) / 2 : (dat['6'] + dat['9']) /2 + 1;
		for (char c = '0'; c <= '9'; c++) {
			if (c == '6'|| c == '9') continue;
			MAX = Math.max(MAX, dat[c]);
		}
	
		int ans = Math.max(check, MAX);
		System.out.println(ans);
		br.close();
	}
}