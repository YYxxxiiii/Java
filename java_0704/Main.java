package java_0704;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int c = (int) Math.pow(n, 2);
            String s1 = "" + c;
            String s2 = s1.substring(1);

            if (s2.length() > 0) {
                int k = Integer.parseInt(s2);
                if (n == k) {
                    System.out.println("Yes!");
                } else {
                    System.out.println("No!");
                }
            } else {
                System.out.println("No!");
            }
        }
    }
}
