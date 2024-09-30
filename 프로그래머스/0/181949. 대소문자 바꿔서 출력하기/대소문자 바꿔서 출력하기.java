import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder sb = new StringBuilder(a);
        for (int i = 0; i < a.length(); i++) {
            char ch = sb.charAt(i);
            if (Character.isLowerCase(ch)) {
                sb.setCharAt(i, Character.toUpperCase(ch));
            } else {
                sb.setCharAt(i, Character.toLowerCase(ch));
            }
        }
        
        System.out.println(sb);
    }
}