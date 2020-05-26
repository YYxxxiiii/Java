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
        Thread.sleep(500);
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
        Thread.sleep(500);
        return (T)element;
    }

    public synchronized int size() {
        return size;
    }

    //模拟使用自定义阻塞队列
    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);
        for(int i=0; i<5; i++){
            new Thread(()->{
                try {
                    while (true) {
                        synchronized (queue) {
                            //模拟生产面包
                            queue.put(1);
                            //打印库存数量，是存在信息不一致的问题
                            //使用不当：size是希望获取put方法调用并执行完放元素操作时的size
                            //         两段代码是有原子性需求，但是没有保证原子性，出现问题
                            //解决方案：加锁，可以是queue对象来加锁，也可以使用其他的对象
                            System.out.println("存放面包+1："+queue.size());
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        for(int i=0; i<20; i++){
            new Thread(()->{
                try {
                    while (true) {
                        synchronized (queue) {
                            //模拟消费面包
                            Integer e = queue.take();
                            System.out.println("消费面包-1："+queue.size());
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
