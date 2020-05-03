public class MyQueueByLinkedList {
  
    static class Node {
        public int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }
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
    public Integer poll() {
        if (head == null) {
            return null;
        }
        int ret = head.val;
        head = head.next;
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
