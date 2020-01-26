package Java_0108;

public class Text {
    private static void textAdd() {
        SeqList seqList = new SeqList();
        seqList.add(0, 100);
        seqList.add(0, 200);
        seqList.add(0, 300);
        seqList.add(0, 400);
        seqList.display();
    }

    public static void main(String[] args) {
        textAdd();
    }
}
