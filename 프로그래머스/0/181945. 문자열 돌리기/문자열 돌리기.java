import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder sb = new StringBuilder();
        sb.append(a.charAt(0));
        for (int i = 1; i < a.length(); i++) {
            sb.append("\n" + a.charAt(i));
        }
        
        System.out.println(sb);
    }
}