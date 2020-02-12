public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(binarySearch(arr,7));
    }
    public static int binarySearch(int[] arr,int toFind){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(toFind < arr[mid]){
                right = mid - 1;
            }else if(toFind > arr[mid]){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}


import java.util.Arrays;

public class ArrayText {   
    public static void reverse(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
}



import java.util.Arrays;

public class Reverse {
    public static void reverse(int[] arr){
        int left = 0;
        int right = arr.length -1;
        while(left < right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
}



 int[] a = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
           a[(i + k) % nums.length] = nums[i];
        }
            for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }


