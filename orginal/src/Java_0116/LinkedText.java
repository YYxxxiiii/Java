package Java_0116;

public class LinkedText {
    private static void textAddFirst() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.display();
    }

    private static void textAddLast() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.display();
    }

    private static void textAddIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.addIndex(0,1);
        linkedList.addIndex(1,5);
        linkedList.addIndex(1,3);
        linkedList.addIndex(1,2);
        linkedList.display();
    }
    private static void textContain() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        System.out.println(linkedList.contain(3));
    }
    private static void textRemove() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.remove(2);
        linkedList.display();
    }

    private static void textClear() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.clear();
        linkedList.display();
        }
    public static void main(String[] args) {
        //textAddFirst();
        //textAddLast();
        //textAddIndex();
        //textContain();
        //textRemove();
        textClear();
    }
}
