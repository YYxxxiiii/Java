package java_0412;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        //1.创建Map 实例，泛型参数有两个，
        // 第一个参数是key类型，第二个参数是 value 的类型
        Map<String,String> map = new HashMap<>();

        System.out.println(map.size());

        System.out.println(map.isEmpty());
        //使用 put 方法存放一些键值对
        map.put("及时雨","宋江");

        //使用 get 方法 根据 key 来查找对应的 value
        //getOrDefault 如果 key 不存在，返回默认值
        System.out.println(map.get("及时雨"));
        System.out.println(map.getOrDefault("及时","鲁智深"));
        //通过 containsKey 和 containsValue 来判定某个值是否存在
        //containsKey 执行效率高
        System.out.println(map.containsKey("智多星"));
        System.out.println(map.containsValue("智多星"));

        //foreach 遍历 Map 中的所有键值对
        //Entry：表示一个“条目” 也就是一个键值对
        //map.entrySet 获取到所有的键值对
        // Map红的元素顺序和插入顺序无关，去结余具体的实现方式
        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
