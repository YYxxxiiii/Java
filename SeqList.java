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
            if(i < size - 1){
                ret += ",";
            }
        }
        ret += "]";
        System.out.println(ret);
    }
    public void add(int pos, int data) {
        if(pos < 0 || pos > size){
            return;
        }
        if(size >= datas.length){  
            int[] newDatas = new int[datas.length * 2];  
            for (int i = 0; i < datas.length ; i++) {
                newDatas[i] = datas[i];
            }
            datas = newDatas; 
        }
        if(pos == size){
            datas[pos] = data;
            size++;
            return;
        }
        for (int i = size - 1;i >= pos;i--) { 
            datas[i + 1] = datas[i];
        }
        datas[pos] = data;
        size++;
    }
    public boolean contains(int toFind) {
        for (int i = 0; i < size; i++) {
            if (datas[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    public int search(int toFind) {  
        for (int i = 0; i < size; i++) {
            if(datas[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    public int getPos(int pos) { 
        return datas[pos];
    }
    public void setPos(int pos, int value) {  
        datas[pos] = value;
    }

    public void remove(int toRemove) { 
        int pos = search(toRemove);  
        if(pos == -1) {  
            return;
        }

        if(pos == size - 1){   
            size--;
            return;
        }
        for(int i = pos;i < size - 1; i++) {  
            datas[i] = datas[i + 1];
        }
        size--;
    }
    public void clear() {
        size = 0;
    }

}
