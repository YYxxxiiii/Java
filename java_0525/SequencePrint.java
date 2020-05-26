package java_0525;

public class SequencePrint {

    //三个线程
    //第一个只能打印A,第二个B,第三个C
    //要求:
    //(1) 三个线程同时执行
    //(2) 打印结果:ABC

    public static void print1() {
        Thread t1 = new Thread(new Print("A", null));
        Thread t2 = new Thread(new Print("B", t1));
        Thread t3 = new Thread(new Print("C", t2));
        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) {
//        print1();
        print2();
    }

    //对该类进行包装,实现打印(传进来是啥,就打印啥)
    private static class Print implements Runnable{
        private String content;//content就是打印你传进来的内容
        private Thread t;

        //可以走外部传进来(constructor)
        public Print(String content,Thread t) {
            this.content = content;
            this.t = t;
        }

        @Override
        public void run() {
            try {
                if (t != null) {
                    t.join();
                }
                System.out.println(content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 升级版要求：
     * （1）同时执行
     * （2）打印结果：
     * ABC
     * ABC
     * 循环打印共计10次
     * 思路：
     * 每个线程循环10次来打印A、B、C
     * 每次打印之后，等待其余线程打印完，再往下执行
     */
    public static void print2(){
        for(int i=0; i<Print2.ARRAY.length; i++){
            new Thread(new Print2(i)).start();
        }
    }

    private static class Print2 implements Runnable{
        private int idx;//传的索引值
        public static String[] ARRAY = {"A", "B", "C", "D", "E"};
        private static int INDEX;
        public Print2(int idx) {
            this.idx = idx;
        }

        @Override
        public void run() {
            try {
                for(int i=0; i<10; i++){
                    synchronized (ARRAY) {
                        while (idx != INDEX) {
                            ARRAY.wait();
                        }
                        System.out.print(ARRAY[idx]);
                        if(INDEX == ARRAY.length - 1) { //数组里的传完了,把他都打印出来
                            System.out.println();
                        }
                        INDEX = (INDEX + 1) % ARRAY.length;
                        ARRAY.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
