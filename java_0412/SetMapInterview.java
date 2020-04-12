package java_0412;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SetMapInterview {
//    public int singleNumber(int[] nums) {
//        // 1. 创建一个 Map 统计每个数字出现的次数, key 表示当前数字, value 表示这个数字出现的次数
//        Map<Integer, Integer> map = new HashMap<>();
//        // 2. 遍历数组, 完成统计
//        for (int x : nums) {
//            Integer value = map.get(x);
//            if (value == null) {
//                // 当前这个数字在 map 中不存在. 就新增一个键值对
//                map.put(x, 1);
//            } else {
//                // 当前这个数字前面已经存在过了~, 把 value 再加 1 即可
//                map.put(x, value + 1);
//            }
//        }
//
//        // 3. 遍历 map, 找到 出现次数 为 1 次的 数字
////        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
////            // getValue 得到的是 Integer 包装类. 通过 equals 判定相当于对 1 进行自动装箱, 比较两个 Integer 的值
////            // 如果写成 == 1, 相当有对 Integer 自动拆箱, 比较两个 ==
////            if (entry.getValue().equals(1)) {
////                return entry.getKey();
////            }
////        }
//        Iterator<HashMap.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            HashMap.Entry<Integer, Integer> entry = iterator.next();
//            if (entry.getValue().equals(1)) {
//                return entry.getKey();
//            }
//        }
//
//        // 理论上讲, 只要输入数组给的是正确的内容, 这里的 return 0 是不会触发的.
//        return 0;
//    }

    public int singleNumber(int[] array) {
        int ret = 0;
        for (int x : array) {
            ret ^= x;
        }
        return ret;
    }

    public int[] singleNumber2(int[] nums) {
        // 1. 先把所有数字异或到一起
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        // 2. 此时的异或结果相当于 a ^ b, 值一定不为 0. 就可以从中找到某个为 1 的 bit 位
        int bit = 1;
        int i = 0;
        for (; i < 32; i++) {
            if ((ret & (bit << i)) != 0) {
                break;
            }
        }
        // 循环结束之后, bit 中的值, 就是刚找到某一位为 1 的值
        // 进行分组
        int a = 0;
        int b = 0;
        for (int x : nums) {
            if ((x & (bit << i)) != 0) {
                // 第一组, 指定位为 1
                a ^= x;
            } else {
                // 第二组, 指定位为 0
                b ^= x;
            }
        }
        int[] array = {a, b};
        return array;
    }

    public static void main(String[] args) {
        SetMapInterview interview = new SetMapInterview();
        int[] array = {1, 1, 2, 2, 4, 5};
        int[] result = interview.singleNumber2(array);
        System.out.println(Arrays.toString(result));
    }

}
