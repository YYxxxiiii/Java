package Java_0408;

import java.util.Arrays;

public class Bubble {
    public static void bubbleSorted(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = arr.length - 1; cur > 0; cur--) {
                if (arr[cur - 1] > arr[cur]) {
                    int tmp = arr[cur - 1];
                    arr[cur - 1] = arr[cur];
                    arr[cur] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,8,4,3};
        bubbleSorted(arr);
        System.out.println(Arrays.toString(arr));
    }
}
