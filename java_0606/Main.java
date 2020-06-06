package java_0606;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        while (n > 8 * i) {
            if ((n % 8 + 8 * i) % 6 == 0) {
                int ret = ((n - 8 * i) / 8) + (n % 8 + 8 * i) / 6;
                System.out.println(ret);
                return;
            }
            i++;
        }
        System.out.println(-1);
    }
}