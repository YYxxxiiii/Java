package java_0801;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int x) {
        val = x;
    }
}

public class RealLinkedList {
    public ListNode head = null;
    public ListNode tail = null;

    public static void main(String[] args) {
        RealLinkedList realLinkedList = new RealLinkedList();
        realLinkedList.addFirst(1);
        realLinkedList.addFirst(2);
        realLinkedList.addFirst(3);
        realLinkedList.addFirst(4);
        realLinkedList.addFirst(4);
        realLinkedList.addFirst(4);


        realLinkedList.remove(4);

        realLinkedList.display();

        realLinkedList.removeAllKey(4);
        realLinkedList.display();
    }

    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            addFirst(data);
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode cur = searchIndex(index);
        ListNode node = new ListNode(data);
        cur.prev.next = node;
        node.prev = cur.prev;
        node.next = cur;
        cur.prev = node;
    }

    private ListNode searchIndex(int index) {
       ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    private int size() {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public void remove(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == head) {
                    head = head.next;
                    head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        tail = cur.prev;
                    }
                }
                return;
            } else {
                cur = cur.next;
            }
        }
    }

    public void removeAllKey(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == head) {
                    head = head.next;
                    head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        tail = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

}
