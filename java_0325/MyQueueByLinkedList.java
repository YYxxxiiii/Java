package java15_0325;

public class MyQueueByLinkedList {
    // Node 这个类叫做 "内部类" . 定义在某个类或者方法中的类
    // static 效果就是: 创建 Node 的实例不依赖 MyQueueByLinkedList 这个类的实例
    static class Node {
        public int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }

    // 创建一个链表, 就得有头结点. 此处 head 节点不是傀儡节点
    // 基于链表来实现队列, 可以入队列从尾部插入, 出队列从头部删除; 也可以如队列从头部插入, 出队列从尾部删除
    // 无论是那种实现方式, 最好都把头和尾都记录下来.
    private Node head = null;
    private Node tail = null;

    // 此处我按照尾部入队列, 头部出队列的方式实现
    // 入队列(标准库中的队列, 入队列操作就叫 offer)
    public void offer(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        // 当前如果不是空链表
        tail.next = newNode;
        tail = tail.next;
    }

    // 出队列
    public Integer poll() {
        // 如果当前队列就是空队列, 再去 poll 显然不科学
        if (head == null) {
            // 如果出队列失败, 返回一个错误值
            return null;
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            // 删除当前元素之后, 队列变成了空的队列
            tail = null;
        }
        return ret;
    }

    // 取队首元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
}
