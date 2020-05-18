package lesson2;

public class DaemonTest {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "第一滴血");
        t.setDaemon(true);
        t.start();
    }
}
