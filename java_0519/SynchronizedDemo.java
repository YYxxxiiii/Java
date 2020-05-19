package java_0519;

public class SynchronizedDemo {

    //语法1.静态方法上：静态同步方法
    public static synchronized void test1(){

    }
    //test1写法=test1_2写法
    public static void test1_2(){
        synchronized (SynchronizedDemo.class){

        }
    }

    //语法2.实例方法上：实例同步方法
    public synchronized void test2(){

    }
    //test2=test2_2的写法
    public void test2_2(){
        synchronized (this){

        }
    }

    public static void main(String[] args) {
        Object o = new Object();
        /**
         * 1.对象锁：每个对象有对象头，包含锁
         * 2.synchronized是获取对象锁的操作：
         *    1)申请对象锁成功：
         *          (1)持有对象锁，并进入代码块
         *          (2)执行代码
         *          (3)退出代码块归还对象锁
         *              --->JVM会将竞争对象锁失败的线程唤醒
         *              --->唤醒的线程重新竞争
         *              --->循环1)和2)的逻辑
         *    2)申请对象锁失败：线程进入一个同步队列中阻塞
         *          JVM管理synchronized竞争失败线程：
         *              --->由运行态转变为阻塞态
         *              --->将线程放到一个同步队列的数据结构中
         *              --->对象锁再次可用，将所有竞争这个对象锁失败的线程唤醒（阻塞转变为被唤醒）
         * 3.对象：普通的Java对象、类对象（JVM把类当作对象来管理）
         * 4.注意事项：
         *    1)多个线程只有对同一个对象申请对象锁时，才会有同步互斥的作用
         *     ————同步互斥：同步代码块，在一个时间点，只有一个线程运行
         *    2)多个线程竞争不同对象的对象锁，不会有同步互斥
         * 5.静态同步方法、实例同步方法都可以转换为同步代码块的写法
         */
        //语法3.同步代码块
        synchronized (o){

        }
    }
}

