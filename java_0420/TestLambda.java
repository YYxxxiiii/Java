package java_0420

import java.util.*;

class MyComp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        // sort 方法默认是按照升序排序. 小的在前, 大的在后.
        // compare 方法相当于是重新定义 什么叫 "小"
        // 如果 返回 < 0 数, 认为 o1 比 o2 小. 此时 o1 排在 o2 前
        // 如果 返回 > 0 数, 认为 o2 比 o1 小. 此时 o2 排在 o1 前
        // 如果 返回 0 , 认为 o1 和 o2 一样小. 此时无所谓.

        // 如果想降序排序, 把 o1 o2 谁的数值大 定义为 "小"
        // 例如 o2 是 2, o1 是 1
        // 做差 > 0, o2 就要排在 o1 前.
        return o2 - o1;
    }
}

// 这个注解的目的和 @Override 类似, 都是为了进行更严格的语法检查
@FunctionalInterface
interface TwoIntParamReturnInt {
    Integer func(Integer a, Integer b);
}

public class TestLambda {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(7);

        // sort 默认是升序排序. 要想让 sort 能降序排序, 就需要给 sort 的第二个参数指定一个比较器对象
        // (o2 - o1) -> o2 - o1
        // 1. lambda 中参数类型可以省略.
        // 2. 如果方法体中只有一行代码, 那 { } 和 return 也能省略
        String str = "test";

        Collections.sort(arrayList, (o1, o2) -> {
            // 变量捕获
            System.out.println(str);
            return o2 - o1;
        });

        System.out.println(arrayList);

    }
}
