package lesson2;

public class StartVsRun {

    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("第一滴血");
//            }
//        }, "子线程Thread Baby").start();
////        new Thread(()-> {
////            System.out.println("第一滴血");
////        }, "子线程Thread Baby").start();
//        System.out.println("main");

        for(int i=0; i<5; i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
    }
}
