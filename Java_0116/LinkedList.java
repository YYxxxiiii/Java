package Java_0116;

//一个节点
class Node {
    public int data;  //数据
    public Node next = null; //下一个节点的位置

    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
    private Node head = null;  //头节点,初始为null,且这个链表没有傀儡节点

    public void display() {
        for(Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    public void addFirst(int data) {
        //头插法
        //1.根据data值,构建一个链表的节点(Node对象)
        //2.如果他是个空链表
        //3.不是空链表
        //1.
        Node node = new Node(data);
        //2.
        if (head == null) {
            head = node;
            return;
        }
        //3.不是空链表
        node.next = head;
        head = node;
    }

    public void addLast(int data) {
        //尾插法
        Node node = new Node(data);
        if(head == null) {
            head = node;
            return;
        }
        //不是空链表的时候,先找出最后一个节点
        Node tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }//循环结束就是最后一个节点
        tail.next = node;
        node.next = null;
    }
    private int getSize() {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }

    public boolean addIndex(int index,int data) {
        //index相当于顺序表里的pos,
        //index就相当于下标
        //1.先判断index的有效性
        int size = getSize();
        if (index < 0 || index > size) {
            return false;
        }
        if (index == 0) {
            addFirst(data);
            return true;
        }
        if (index == size) {
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        Node prev = getPos(index - 1);
        node.next = prev.next;
        prev.next = node; //这个地方顺序不能错了
        return true;

    }
    private Node getPos(int index) {//给定下标index,找到节点
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;//这步操作的提前必须得保证cur是非null
        }
        return cur;
    }
     public boolean contain(int key) {
        for (Node cur = head; cur != null;cur = cur.next) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
     }

     public void remove(int key) {
        //1.头节点
         if (head.data == key) {
             head = head.next;
             return;
         }
         //2.不是头节点,那就得找到该节点的前一个节点
         Node prev = searchPrev(key);
         Node toDelete = prev.next;
         prev.next = toDelete.next;
     }

     private Node searchPrev(int key) {//找key前一个节点
        for (Node cur = head; cur != null
                && cur.next != null;cur = cur.next) {
            if (cur.next.data == key) {
                return cur;
            }
        }
        return null;
     }

     public void removeAll(int key) {
        //1.先删除非头节点情况,需要找到key的前一个节点
         //2.删除是头节点的情况
         //1.
         Node prev = head;
         Node cur = head.next;
         while (cur != null) {
             if (cur.data == key) {
                 prev.next = cur.next;
                 cur = prev.next;
             }else {
                 //prev和cur同时往后移
                 prev = cur;
                 cur = cur.next;
             }
         }
         //2.头结点情况
         if (head.data == key) {
             head = head.next;
         }
     }

     public void clear() {
        head = null;
     }
}

