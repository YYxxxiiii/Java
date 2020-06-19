package java_0619;

public class UnusualAdd {
    public static int addAB(int A, int B) {
        //return A + B;
        if (B == 0) {
            return A;
        }
        int sum = A ^ B;
        int carry = (A & B) << 1;
        if (carry == 0) {
            return sum;
        }
        return addAB(sum, carry);
    }

    public static void main(String[] args) {
        int ret = addAB(1,2);
        System.out.println(ret);
    }
}

