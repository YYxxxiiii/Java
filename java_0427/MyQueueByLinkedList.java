package java_0427;

public class MyQueueByLinkedList {
    //Node 这个类叫做"内部类,定义在某个类或者方法中的类
    //static 效果就是: 创建Node 的实例不依赖 MyQueueByLinkedList 这个类的实例
    static class Node {
        public int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }

    //创建一个链表,就需要头结点,此处 head 节点不是傀儡节点
    //基于链表来实现队列,可以入队列从尾部插入,出队列从头部删除,也可以反过来
    //无论是上面哪种顺序,最好都把头尾记录下来
    private Node head = null;
    private Node tail = null;

    //入队列
    public void offer(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        //当前不是空链表
        tail.next = newNode;
        tail = tail.next;
    }

    //出队列
    //包装类 包装类也是一个引用类型的对象 引用类型他就可以是一个空引用,
    //空引用就可以表示他是非法情况,而如果是其他的值 那就是非空引用,在里面再包含一个具体的值就ok
    public Integer poll() {
        if (head == null) {
            //如果出队列失败,返回一个错误值
            return null;
        }
        int ret = head.val;
        head = head.next;

        //删除当前元素之后,队列变成了空队列的情况
        if (head == null) {
            tail = null;
        }
        return ret;
    }
    //取队首元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }

}
