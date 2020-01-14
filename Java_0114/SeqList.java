package Java_0114;

public class SeqList {
    private int[] datas = new int[100];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void display(){
        String ret = "[";
        for (int i = 0; i < size; i++) {
            ret += arr[i];
            if(i != size -1){
                ret += ",";
            }
        }
        ret += "]";
        System.out.println(ret);
    }
    public void add(int pos,int data){
        if(pos < 0 || pos > size){
            return;
        }
        if(size >= datas.length){
            int[] newDatas = new int[datas.length * 2];
            for (int i = 0; i < datas.length; i++) {
                newDatas[i] = datas[i];
            }
            datas = newDatas;
        }
        //尾插
        if(pos == size){
            datas[pos] = data;
        }


        }
    }
}
