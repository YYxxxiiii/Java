package Java_0115;

public class Text {

    private static void textAdd() {
        SeqList seqList = new SeqList();
        seqList.add(0, 3);
        seqList.add(0, 2);
        seqList.add(1, 6);
        seqList.add(0, 2);
        seqList.display();
    }

    private static void textContain() {
        SeqList seqList = new SeqList();
        seqList.add(0, 3);
        seqList.add(0, 2);
        seqList.add(1, 6);
        seqList.add(0, 2);
        System.out.println(seqList.contains(1));

    }

    private static void textSearch() {
        SeqList seqList = new SeqList();
        seqList.add(0, 4);
        seqList.add(0, 3);
        seqList.add(0, 2);
        seqList.add(0, 1);
        System.out.println(seqList.search(5));
    }

    private static void textGetPos() {
        SeqList seqList = new SeqList();
        seqList.add(0, 4);
        seqList.add(0, 3);
        seqList.add(0, 2);
        seqList.add(0, 1);
        System.out.println(seqList.getPos(2));
    }

    private static void textRemove() {
        SeqList seqList = new SeqList();
        seqList.add(0, 4);
        seqList.add(0, 2);
        seqList.add(0, 2);
        seqList.add(0, 1);
        seqList.remove(2);
        seqList.display();

    }

    private static void textSize() {
        SeqList seqList = new SeqList();
        seqList.add(0, 4);
        seqList.add(0, 3);
        seqList.add(0, 2);
        System.out.println(seqList.getSize());
    }
        public static void main(String[] args) {
            //textAdd();
            //textContain();
            //textSearch();
            //textGetPos();
           // textRemove();
            textSize();
        }

}
