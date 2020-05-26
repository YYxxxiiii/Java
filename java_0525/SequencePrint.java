package java_0525;

public class SequencePrint {

    //三个线程
    //第一个只能打印A,第二个B,第三个C
    //要求:
    //(1) 三个线程同时执行
    //(2) 打印结果:ABC
    //升级版要求:
    //(1) 同时执行
    //(2) 打印结果:
    //ABC
    //ABC
    //循环打印10次
    //思路:
    //每个线程循环10次来打印A.B.C
    //每次打印之后,等待其余线程打印完
    public static void print1() {
        Thread t1 = new Thread(new Print("A", null));
        Thread t2 = new Thread(new Print("B", t1));
        Thread t3 = new Thread(new Print("C", t2));
        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) {
        print1();
    }

    //对该类进行包装,实现打印(传进来是啥,就打印啥)
    private  static class Print implements Runnable{
        private String content;
        private Thread t;

        //可以走外部传进来
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
                System.out.println(content); //content就是打印你传进来的内容
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
