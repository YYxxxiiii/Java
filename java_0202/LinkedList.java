package java15_0105;

// 一个节点
class Node {
    public int data;   // 数据
    public Node next = null;  // 下一个节点的位置

    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
    // 管理所有的链表节点. 只需要记录头结点的位置即可
    // 初始情况下 head 为 null, 此时表示空链表(不带傀儡节点)
    private Node head = null;

    public void addFirst(int data) {
        // 1. 根据 data 值构建一个链表节点(Node对象)
        Node node = new Node(data);
        // 2. 如果链表为空链表
        if (head == null) {
            head = node;
            return;
        }
        // 3. 如果链表不是空链表
        node.next = head;
        head = node;
    }

    public void addLast(int data) {
        // 1. 根据 data 构造一个 Node 对象
        Node node = new Node(data);
        // 2. 如果链表为空链表
        if (head == null) {
            head = node;
            return;
        }
        // 3. 如果链表非空, 需要先找到这个链表末尾的最后一个节点
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        // 循环结束之后, tail 就对应到最后一个节点了
        tail.next = node;
    }

    public void display() {
        // 把链表中的每个元素都打印出来
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    public int getSize() {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    // 插入成功, 返回 true, 否则 false
    public boolean addIndex(int index, int data) {
        int size = getSize();
        // 1. 判定 index 是否有效
        if (index < 0 || index > size) {
            // index 无效, 插入失败
            return false;
        }
        // 2. 如果 index 为 0, 相当于头插
        if (index == 0) {
            addFirst(data);
            return true;
        }
        // 3. 如果 index 为 size, 相当于尾插
        if (index == size) {
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        // 4. 如果 index 是一个中间的位置
        //  a) 先找到 index 的前一个节点 index - 1
        Node prev = getPos(index - 1);
        //  b) 接下来就把新节点插入到 prev 之后
        // 注释是头插的代码
        // node.next = head;
        // head = node;
        node.next = prev.next;
        prev.next = node;
        return true;
    }

    // 给定 index 下标, 找到对应的节点
    private Node getPos(int index) {
        Node cur = head;
        for (int i = 0; i < index; i++) {
            // cur.next 操作之前必须要保证
            // cur 是非 null 的
            cur = cur.next;
        }
        return cur;
    }

    public boolean contains(int toFind) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.data == toFind) {
                return true;
            }
        }
        return false;
    }

    public void remove(int toRemove) {
        // 1. 如果要删除元素是头结点, 特殊处理一下
        if (head.data == toRemove) {
            // 头结点要被删掉
            head = head.next;
            return;
        }
        // 2. 如果要删除元素不是头结点, 找到要删除节点的前一个位置
        Node prev = searchPrev(toRemove);
        // 3. 修改引用的指向, 完成删除
        // prev.next = prev.next.next;
        Node toDelete = prev.next;
        prev.next = toDelete.next;
    }

    private Node searchPrev(int toRemove) {
        // 找到 toRemove 的前一个节点
        for (Node cur = head; cur != null
                && cur.next != null; cur = cur.next) {
            if (cur.next.data == toRemove) {
                return cur;
            }
        }
        return null;
    }
}
