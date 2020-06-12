package java_0612;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            n /= 5;
            cnt += n;
        }
        System.out.println(cnt);
    }
}
