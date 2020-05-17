package java_0517;

public class InterruptThread {

    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread(()-> {
//            while (!Thread.interrupted()) {
//                try {
//                    System.out.println(Thread.currentThread().getName());
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t.start();
//        Thread.sleep(3000);
//        t.interrupt();

        Thread t = new Thread(()->{//isInterrupted=true;
            for(int i=0; i<10; i++) {
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        t.start();//t.isInterrupted=false;
        //特殊情况出现，要中断子线程
        t.interrupt();//t.isInterrupted=true
    }
}
