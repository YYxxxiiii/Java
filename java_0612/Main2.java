package java_0612;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入一个整数：");
        int num = input.nextInt();
        while (num != 0) {
            System.out.print(num % 10);
            num /= 10;
        }
    }
}