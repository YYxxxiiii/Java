package java_0516;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()-> {
            try {
                Thread.sleep(3000);
                System.out.println("Thread Baby");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.join(5000);//通过修改这个时间,可以调整传入参数 5000时先TB 1000时先main
        System.out.println("main");
    }
}
