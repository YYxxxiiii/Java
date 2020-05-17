package java_0517;


//有一个共享变量,初始为0,启动20个线程,每个线程循环1000,每次循环将共享变量++
public class UnsafeThread {

    private static int SUM;
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()-> {
                for (int j = 0; j < 10000; j++) {
                    SUM++;
                }
            }).start();
        }
        //所有子线程执行完毕之后,打印SUM的值
        while(Thread.activeCount() > 1) {//用debug运行ok的,如果直接run,得把1改成2
            Thread.yield();//当前线程(main)由运行态转变为就绪态
        }
        System.out.println(SUM);
    }
}
