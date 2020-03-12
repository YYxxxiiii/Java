package java_0312;


class Node {
    public int data;
    public Node next = null;
    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
        private Node head = null;
        // private Node tail = null;  // 优化尾插
        // private int size = 0;      // 优化获取长度

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
            if (head == null) {
                head = node;
                return;
            }
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;
        }

        public void display() {
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
        public boolean addIndex(int index, int data) {
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
        private Node getPos(int index) {
            Node cur = head;
            for (int i = 0; i < index; i++) {
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
            if (head.data == toRemove) {
                head = head.next;
                return;
            }
            Node prev = searchPrev(toRemove);
            Node toDelete = prev.next;
            prev.next = toDelete.next;
        }

        private Node searchPrev(int toRemove) {
            for (Node cur = head; cur != null
                    && cur.next != null; cur = cur.next) {
                if (cur.next.data == toRemove) {
                    return cur;
                }
            }
            return null;
        }

        public void removeAll(int toRemove) {
            Node prev = head;
            Node cur = head.next;
            while (cur != null) {
                if (cur.data == toRemove) {
                    prev.next = cur.next;
                    cur = prev.next;
                } else {

                    prev = cur;
                    cur = cur.next;
                }
            }
            if (head.data == toRemove) {
                head = head.next;
            }
        }

        public void clear() {
            head = null;
        }
    }
