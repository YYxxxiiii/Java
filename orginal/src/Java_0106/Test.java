package Java_0106;

public class Test {
    public static void main(String[] args) {
        //textAdd();
        //textContains();
        textSearch();
        //textRemove();
    }

    private static void textAdd(){
        SeqList seqList = new SeqList();
        seqList.add(0, 2);
        seqList.add(0, 3);
        seqList.add(0, 5);
        seqList.add(1, 6);
        seqList.display();
    }

    private static void textContains() {
        SeqList seqList = new SeqList();
        seqList.add(0, 1);
        seqList.add(0, 2);
        seqList.add(0, 3);
        seqList.add(0, 4);
        System.out.println(seqList.contains(2));

    }
    private static void textSearch() {
        SeqList seqList = new SeqList();
        seqList.add(0, 2);
        seqList.add(0, 3);
        seqList.add(0, 5);
        seqList.add(1, 6);
        System.out.println(seqList.search(3));
    }

    private static void textRemove() {
        SeqList seqList = new SeqList();
        seqList.add(0, 2);
        seqList.add(0, 3);
        seqList.add(0, 5);
        seqList.add(0, 6);
        seqList.remove(3);
        seqList.display();
    }

}
