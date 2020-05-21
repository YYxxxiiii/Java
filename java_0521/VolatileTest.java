package lesson5;

public class VolatileTest {

    private static volatile int SUM;

    public static void increment(int n){
        /**
         * 分解为三条指令：
         * 1.从主内存读取SUM到工作内存
         * 2.在工作内存中修改SUM变量的值为SUM+1
         * 3.写回主内存
         */
        SUM++;
    }

    public static void main(String[] args) {
        for(int i=0; i<20; i++){
            new Thread(()->{
                for(int j=0; j<10000; j++){
                    increment(j);
                }
            }).start();
        }
        //所有子线程执行完毕之后，打印SUM的值
        while(Thread.activeCount() > 1) {//idea使用debug运行，run运行的话，>2。
            Thread.yield();//当前线程由运行态转变为就绪态
        }
        System.out.println(SUM);
    }
}
