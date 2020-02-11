package Java_0211;

public class Hahah {
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

    public int search(int toFind) {
        for (int i = 0; i < size; i++) {
            if (datas[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int toFind) {
        for (int i = 0; i < size; i++) {
            if (datas[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    public void add(int pos, int data) {
        if (pos < 0 || pos > size) {
            return;
        }
        if (size >= datas.length) {
            int[] newData = new int[2 * datas.length];
            for (int i = 0; i < datas.length; i++) {
                newData[i] = datas[i];
            }
            datas = newData;
        }
        if (pos == size) {
            datas[pos] = data;
            size++;
            return;
        }
        for (int i = size - 1; i >= pos ; i--) {
            datas[i + 1] = datas[i];
        }
        datas[pos] = data;
        size++;
    }
    public void remove(int toRemove) {
        int pos = search(toRemove);
        if (pos == -1) {
            return;
        }
        if (pos == size -1) {
            size--;
            return;
        }
        for (int i = pos; i < size; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
    }

    public int getPos(int pos) {
        return datas[pos];
    }
    public void setPos(int pos,int data) {
        datas[pos] = data;
    }
}

