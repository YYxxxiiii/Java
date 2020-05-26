package java_0525;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 阻塞式队列:
 * (1) 基于数组的循环队列实现
 * (2) 提供一个队列,取元素消费的时候
 *          如果队列为空,阻塞等待
 *          如果满了,存元素生产的时候,组赛等待
 */
public class MyBlockingQueue<T> {

    private Object[] table;
    private int takeIndex; //取元素时的索引
    private int putIndex; //存放元素时的索引
    private int size;//保存的元素的大小


    public MyBlockingQueue(int capacity) {
        table = new Object[capacity];
    }
    public synchronized void put(T element) throws InterruptedException {
        while (size == table.length) {
            wait();
        }
        table[putIndex] = element;//存放元素
        putIndex = (putIndex + 1) % table.length;
        size++;
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (size == 0) {
            wait();
        }
        Object element = table[takeIndex];
        takeIndex = (takeIndex + 1) % table.length;
        size--;
        notifyAll();
        return (T)element;
    }

    //模拟使用自定义阻塞队列
    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);//ca容量
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    //模拟生产面包
                    try {
                        queue.put(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("存放面包+1");
                }
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    //模拟消费面包
                    try {
                        Integer e = queue.take();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    System.out.println("消费面包-1");
                }
            }).start();
        }
    }
}
