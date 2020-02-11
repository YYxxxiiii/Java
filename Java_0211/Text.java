package Java_0211;

public class Text {
    private static void testAdd() {
        SeqList seqList = new SeqList();
        seqList.add(0, 100);
        seqList.add(0, 200);
        seqList.add(0, 300);
        seqList.add(0, 400);
        seqList.display();
    }

    private static void testContains() {
        SeqList seqList = new SeqList();
        seqList.add(0, 1);
        seqList.add(0, 2);
        seqList.add(0, 3);
        seqList.add(0, 4);
        System.out.println(seqList.contains(2));
    }

    private static void testSearch() {
        SeqList seqList = new SeqList();
        seqList.add(0, 1);
        seqList.add(0, 2);
        seqList.add(0, 3);
        seqList.add(0, 4);
        System.out.println(seqList.search(3));
    }

    private static void testRemove() {
        SeqList seqList = new SeqList();
        seqList.add(0, 1);
        seqList.add(0, 2);
        seqList.add(0, 3);
        seqList.add(0, 4);
        seqList.remove(2);
        seqList.display();
    }

    public static void main(String[] args) {
        testAdd();
    }



}
