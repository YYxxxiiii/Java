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
        Thread t1 = new Thread(new Print("A"));
        Thread t2 = new Thread(new Print("B"));
        Thread t3 = new Thread(new Print("C"));
    }

    public static void main(String[] args) {

    }

    //对该类进行包装,实现打印(传进来是啥,就打印啥)
    private  static class Print implements Runnable{
        private String content;


        //可以走外部传进来
        public Print(String content) {
            this.content = content;
        }

        @Override
        public void run() {
            System.out.println(content);
        }
    }
}
