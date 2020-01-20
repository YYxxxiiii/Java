package J0120;

public class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums == null) {
                return 0;
            }
            int s = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[s] = nums[i];
                    s++;
                }
            }
            return s;
        }

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 0;
        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

 public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }






    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] < target) {
                continue;
            } else if (nums[i] > target) {
                break;
            }
        }
        return i;
    }



    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
