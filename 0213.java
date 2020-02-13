class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length != 0) {
                return length;
            }
        }
        return length;
    }
}



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
    private Node head = null;  
    public void display() {
        for(Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }
    public void addFirst(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
            return;
        }
        Node tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
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
        prev.next = node;
        return true;

    }
    private Node getPos(int index) {//给定下标index,找到节点
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
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
         if (head.data == key) {
             head = head.next;
             return;
         }
         Node prev = searchPrev(key);
         Node toDelete = prev.next;
         prev.next = toDelete.next;
     }

     private Node searchPrev(int key) {
        for (Node cur = head; cur != null
                && cur.next != null;cur = cur.next) {
            if (cur.next.data == key) {
                return cur;
            }
        }
        return null;
     }
     public void removeAll(int key) {
         Node prev = head;
         Node cur = head.next;
         while (cur != null) {
             if (cur.data == key) {
                 prev.next = cur.next;
                 cur = prev.next;
             }else {
                 //prev和cur
                 prev = cur;
                 cur = cur.next;
             }
         }
         if (head.data == key) {
             head = head.next;
         }
     }

     public void clear() {
        head = null;
     }
}

