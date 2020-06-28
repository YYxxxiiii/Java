package java_0619;

import java.util.Scanner;

public class Main {
    public static int Hunger(int x) {
        if (x % 1000000007 == 0) {
            return 0;
        }
        int num = 0;
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int ret = Hunger(n);
            System.out.println(ret);
        }
    }
}
