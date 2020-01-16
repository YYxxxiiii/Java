package Java_0115;

public class SeqList {
    private int[] datas = new int[100];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void display() {
        String ret = "[";
        for (int i = 0; i < size; i++) {
            ret += datas[i];
            if (i < size - 1) {
                ret += ",";
            }
        }
        ret += "]";
        System.out.println(ret);
    }

    public void add(int pos,int data){
        //1.有效性
        if (pos < 0 || pos > size){
            return;
        }
        //2.扩容
        if (size >= datas.length){
            int[] newDatas = new int[2 * datas.length];
            //给新的把原来的值搬过去
            for (int i = 0; i < datas.length; i++) {
                newDatas[i] = datas[i];
            }
            datas = newDatas;
        }
        //3.尾插
        if (pos == size){
            datas[pos] = data;
            size++;
            return;  //如果没有这个return 那么尾插的那个值就会算两次
        }
        //4.正常插法
        for (int i = size - 1; i >= pos; i--) {
            datas[i + 1] = datas[i];
        }
        datas[pos] = data;
        size++;
    }
    public boolean contains (int toFind) {
        for (int i = 0; i < size; i++) {
            if (toFind == datas[i]) {
                return true;
            }
        }
        return false;
    }
    public int search (int toFind) {
        //找这个数对应的下标
        for (int i = 0; i < size; i++) {
            if (toFind == datas[i]) {
                return i;
            }
        }
        return -1;
    }

//    public int getPos (int pos) {
//        for (int i = 0; i < size; i++) {
//            if (datas[i] == datas[pos]){
//                return datas[i];
//            }
//        }
//        return -1;
//    }
    public int getPos (int pos) {
        return datas[pos];
    }

    public void setPos (int pos,int value){
        datas[pos] = value;
    }

    public void remove (int toRemove) {
        int pos = search(toRemove);
        if (pos == -1) {
            return;
        }
        if (pos == size - 1){
            size--;
            return;
        }
        for (int i = pos; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
    }
    public void clear() {
        size = 0;
    }

}
