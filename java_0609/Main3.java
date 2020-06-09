package java_0609;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k;
        int q;
        int ret = 0;
        if (a > b) {
            k = a;
            q = b;
        } else {
            k = b;
            q = a;
        }
        for (int i = 1; i <= k; i++) {
            if (i * q % k == 0) {
                ret = i * q;
            }
        }
        System.out.println(ret);
    }
}
