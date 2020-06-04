package java_0604;

import java.util.Scanner;

public class what {
    public static int change(int n) {
        int count = 0;
        while(n > 2) {
            count += n/3;
            n = n/3 + n % 3;
        }
        if(n == 2) {
            count += 1;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while(sc.hasNext()) {
            n = sc.nextInt();
            System.out.println(change(n));
        }
    }
}


