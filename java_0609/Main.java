package java_0609;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int num = 0;
        if ((w < 1 || h < 1)|| (w > 100 || h > 100)){
            return;
        }
        if (w % 4 == 0 || h % 4 == 0) {
            num = w * h / 2;
        } else if (w % 2 == 0 || h % 2 == 0) {
            num = (w * h / 4 + 1) * 2;
        } else {
            num = (w * h )/ 2 + 1;
        }
        System.out.println(num);
    }
}
