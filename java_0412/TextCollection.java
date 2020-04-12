package java_0412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TextCollection {
    public static void main(String[] args) {
        //1.创建Collection
        Collection<String> collection = new ArrayList<>();
        //因为Collection是个接口所以不能直接newCollection
        // 所以得new一个类
        // 接下来就像谁可以实现Collection这个接口
        //这里采用了个简单的ArrayList

        //2.使用 size 方法（这个集合有多少元素）
        System.out.println(collection.size());
        //3.使用isEmpty方法
        System.out.println(collection.isEmpty());
        //4.使用 add 方法 插入元素
        collection.add("我");
        collection.add("是");
        //add 中的参数类型必须和泛型类型相匹配

        //5.再次使用 size 和 isEmpty
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());

        //6. 用toArray 把Collection类型转换成数组
        //得到的结果是 Object[]
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
        //7.直接使用for循环来遍历集合中的元素
        //此时 是一个简单的写法 ， 要想使用普通的for 循环，
        // 那就得用到 迭代器（Iterator）
        for (String s : collection) {
            //s 就会分别指向 collection 中的每一个元素
            System.out.println(s);
        }
        //8 使用contains 放大判定元素是否存在（equals）（比的是值）
        System.out.println(collection.contains("我"));
         //9.使用 remove 来删除元素
        collection.remove("我");
        System.out.println("删除之后：");
        for (String s : collection) {
            System.out.println(s);
        }
        //10. 使用clear 方法清空所有方法
        collection.clear();
        System.out.println("清空后：");
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
    }
}
