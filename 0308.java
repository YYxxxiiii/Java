public boolean isLongPressedName(String name, String typed) {
        int m = name.length();
        int k = typed.length();
        if (m > k) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < m && j < k) {
            if(name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            }else{
                j++;
            }
        }
        if (i == m) {
            return true;
        }
        return false;
    }

你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。

你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。

public boolean containsDuplicate(int[] nums) {
Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1;i++) {
            if (nums[i + 1] == nums[i]) {
                return true;
            }
        }
        return false;
}
}