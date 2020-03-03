package Java_0303;

public class LinkedList {
    static class Node{
        public int data;//这是一个数据
        public Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    //管理所有的链表节点,只需要记录头节点的位置即可,
    //即,下方的这个head就是所谓的头节点
    private Node head = null;

    //这个是头插
    public void addFirst(int data) {
        //根据Node类里的data数据构建一个链表节点
        //也就是Node对象
        Node node = new Node(data);
        //1.先判断是否是个空链表
        if(head == null) {
            head = node;//这个node就是往上第三行这个node
            return;
        }
        //2.如果他不是个空链表
        node.next = head;
        head = node;//node这个链表是由head领头的
    }

    //接下来这个是尾插
    public void addLats(int data) {
        //依旧先得根据data构造一个Node对象
        Node node = new Node(data);
        //判断他是不是个空的
        if (head == null) {
            head = node;
            return;
        }
        //接下来就是不是空的的情况啦
        //我们得先找到这个链表的最后一个节点
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }//这个while循环结束之后呢
        //就找到了最后一个节点
        tail.next = node;
    }

    //这个是打印打印出来
    public void display() {
        for (Node cur = head;cur != null;cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    public int getSize() {
        int size = 0;
        for (Node cur = head;cur != null;cur = cur.next) {
            size++;
        }
        return size;
    }


    //往某下标插入一个数据
    public boolean addIndex(int index,int data) {
        
    }
}
