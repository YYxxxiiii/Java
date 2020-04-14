package java_0414;

import java.util.*;

public class MapInterview {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // 1. 遍历旧链表, 把旧链表每个节点依次插入到 map 中. key 是旧链表节点, value 是拷贝出来的新节点
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        // 2. 再次遍历链表, 修改新链表节点中的 next 和 random
        for (Node cur = head; cur != null; cur = cur.next) {
            // 先从 map 中找到该 cur 对应的新链表节点
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        // 需要返回新链表的头结点
        return map.get(head);
    }

    public int numJewelsInStones(String J, String S) {
        // 1. 先遍历 J 把所有的宝石类型加入到一个 Set 中
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        // 2. 遍历 S 拿到每个元素取 set 中查找, 如果能找到就说明是宝石
        int ret = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                ret++;
            }
        }
        return ret;
    }

    static class MyComparator implements Comparator<String> {
        private Map<String, Integer> map;

        public MyComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                // String 自身也实现了Comparable, 自带字典序的比较功能的
                // compareTo 就是在使用 String 默认的比较规则
                return o1.compareTo(o2);
            }
            // o1 < o2 返回 < 0
            // o1 > o2 返回 > 0
            // o1 == o2 返回 0
            // count1 - count2 升序排序
            // count2 - count1 降序排序
            // 或者换种理解方式:
            // sort 就是按照升序来排序(小的放前, 大的放后)
            // 这两样的表达式是在重新定义 "什么叫做小"
            // count1 - count2 就是定义了出现次数少的比较小.
            // count2 - count1 就是定义了出现次数多的比较小
            return count2 - count1;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        // 1. 先统计每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            Integer count = map.getOrDefault(s, 0);
            map.put(s, count + 1);
        }
        // 2. 把刚才这里的统计到的字符串内容放到 ArrayList 中
        // keySet 相当于得到了一个 Set, Set 中存放的就是所有的 key
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        // 3. 按照刚才字符串出现次数, 针对 arrayList 进行排序
        //    sort 默认是按照元素的自身大小进行升序排序(String 的字典序)
        //    此处我们需要按照 字符串 出现次数来降序排序. 也就需要通过比较器自定制比较规则
        // Collections.sort(arrayList, new MyComparator(map));

        // 下面的代码创建了一个 "匿名内部类"
        // 你不知道这个类名字是啥, 但是你知道这个类实现了 Comparator 接口
        // 啥时候需要使用? 这个类只需要用一次, 用完就丢了. 这时候就可以用匿名内部类.
//        Collections.sort(arrayList, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int count1 = map.get(o1);
//                int count2 = map.get(o2);
//                if (count1 == count2) {
//                    return o1.compareTo(o2);
//                }
//                return count2 - count1;
//            }
//        });
        // lambda 表达式. 本质上就是一个匿名方法.
        // o1 o2 的类型就是 String 类型.
        Collections.sort(arrayList, (o1, o2) -> {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                return o1.compareTo(o2);
            }
            return count2 - count1;
        });
        return arrayList.subList(0, k);
    }

    static class MyEntry<K, V> {
        K key;
        V value;

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }
    }

    static class MyComp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static void main(String[] args) {
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1, 10);
//        map.put(2, 20);
//        map.put(3, 30);
//        map.put(4, 40);

        // 1. 使用迭代器.
        // Entry 表示一个键值对. (key, value)
        // entrySet 包含 Entry 的 Set  Set<Entry<Integer, Integer> >
//        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, Integer> entry = iterator.next();
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        // 2. 使用 for each . foreach 本质上就是靠迭代器来遍历. 不需要程序猿手动写迭代器的代码
        //    迭代器代码由编译器自动生成的.
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        int[] array = {9, 5, 2, 7};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
