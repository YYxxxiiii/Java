package Java_0117;

public class RightArrays {
    public void rotate(int[] nums, int k) {
        int p = nums.length;
        for (int cur = 0;cur < k; cur++){
            int tmp = nums[p - 1];
            for(int i = p - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = tmp;
        }
    }

//2.
        int[] a = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
            for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }



    //3.
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }




    }
