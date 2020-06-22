package java_0622;

public class Main {
        public static void main (String[] args) {
            int n = 10 * 30;
            int r = 0;
            for (int i = 1;i <= 30;i++){
                r = r + 2*i^(n-1);
            }
            System.out.println(n + " " + r);
        }
    }
}
