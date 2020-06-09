package java_0609;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int num = 0;
        int[][] arr = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (arr[i][j] != -1) {
                    num++;
                    if (i + 2 < w) {
                        arr[i +2][j] = -1;
                    }
                    if (j + 2 < h) {
                        arr[i][j + 1] = -1;
                    }
                }
            }
        }
        System.out.println(num);
    }
}
