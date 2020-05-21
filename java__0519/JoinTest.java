package lesson2;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
//            System.out.println("Thread Baby");
            try {
                Thread.sleep(3000);
                System.out.println("Thread Baby");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.join(5000);//可以调整传入参数：不传、1000、5000，分别观察结果
        System.out.println("main");
    }
}
