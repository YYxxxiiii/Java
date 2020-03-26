package java15_0326;

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

    private Node head = null;
    private Node tail = null;

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
        if (head == null) {
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
