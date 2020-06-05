package java_0605;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            int num = 0;
            int maxlong = 0;
            int x = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    num++;
                    if (maxlong < num) {
                        maxlong = num;
                        x = i;
                    }
                }
            }
            System.out.println(str.substring(x - maxlong + 1,x + 1));
            }
        }
    }

}
