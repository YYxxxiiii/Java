

public class SeqList {
    private int[] datas = new int[100];
    private int size = 0;

    public int getSize() {
        // size 这个成员只能提供 get 方法, 不能提供 set
        // size 是通过后面是增删方法来进行维护的.
        return size;
    }

    public void display() {
        // 依次打印出每个元素
        // 形如: [1, 2, 3, 4]
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += datas[i];
            if (i < size - 1) {
                result += ",";
            }
        }
        result += "]";
        System.out.println(result);
    }

    // pos 表示新元素要插入的位置(下标).
    // data 表示新元素的值
    public void add(int pos, int data) {
        // 判定 pos 是否是有效的值
        // 写代码的时候要时刻关注参数的有效性
        if (pos < 0 || pos > size) {
            return;
        }
        // 扩容的支持, 顺序表如果容量不够了, 就能自动扩容
        if (size >= datas.length) {
            // 需要扩容
            int[] newDatas = new int[2 * datas.length];
            for (int i = 0; i < datas.length; i++) {
                newDatas[i] = datas[i];
            }
            datas = newDatas;
        }

        // 1. 尾插的情况(比较简单的情况)
        //    把这个新元素放到下标为 size 的位置上.
        if (pos == size) {
            datas[pos] = data;
            size++;
            return;
        }
        // 2. 普通位置的插入
        for (int i = size - 1; i >= pos; i--) {
            datas[i + 1] = datas[i];
        }
        datas[pos] = data;
        size++;
    }

    public boolean contains(int toFind) {
        // 循环访问每个元素并进行比较.
        // 如果发现某个元素和 toFind 相等, 就找到了, 返回 true
        // 如果所有元素都找完了, 也没找到相等的, 就返回 false
        for (int i = 0; i < size; i++)  {
            if (datas[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    public int search(int toFind) {
        for (int i = 0; i < size; i++)  {
            if (datas[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    public int getPos(int pos) {
        return datas[pos];
    }

    public void setPos(int pos, int data) {
        datas[pos] = data;
    }

    // toRemove 表示要被删除的元素
    public void remove(int toRemove) {
        // 1. 先找到 toRemove 对应的下标
        int pos = search(toRemove);
        if (pos == -1) {
            // 没找到, 要删除的元素不存在
            return;
        }
        // 2. 如果下标是最后一个元素, 直接尾删即可.
        if (pos == size - 1) {
            size--;
            return;
        }
        // 3. 如果下标是中间元素, 需要先搬运, 再删除
        for (int i = pos; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
    }

    public void clear() {
        size = 0;
    }
}
