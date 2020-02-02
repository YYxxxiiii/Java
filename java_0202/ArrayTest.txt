package java15_0105;

public class ArrayTest {
    public static void bubbleSort(int[] arr) {//升序排序
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = 0; cur < arr.length-bound-1; cur++) {
                if(arr[cur]>arr[cur+1]){
                    int tmp = arr[cur];
                    arr[cur] = arr[cur + 1];
                    arr[cur + 1] = tmp;
                }
            }
        }
    }

    public static int binarySearch(int[] arr, int toFind) {
        // [left, right]
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
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

    public static void reverse(int[] arr) {
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
}
