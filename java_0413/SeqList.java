package java_0413;

public class SeqList<E> {
    private E[] data = (E[])new Object[100];
    private int size;

    public void add(E elem) {
        data[size] = elem;
        size++;
    }

    public E get(int index) {
        return data[index];
    }

    public static void main(String[] args) {
        SeqList<String> seqList = new SeqList();
        seqList.add("aaa");
        seqList.add("bbb");
        //调用get的时候返回的是Object,这里需要向下转型
        String str = (String)seqList.get(0);

        SeqList<Animal> animals = new SeqList<>();
        animals.add(new Animal());
        Animal animal = animals.get(0);

    }
}
