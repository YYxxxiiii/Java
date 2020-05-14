package java_0514;

public class FirstBlood {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(9999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "葡萄").start();
        Thread.sleep(9999999999L);
    }
}
