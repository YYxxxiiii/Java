package java_0524;

import java.sql.SQLInvalidAuthorizationSpecException;

//假设面包店有面包师傅.消费者
//1.面包师傅有5个,可以一直生产面包,每次生产三个
//2.消费者有20个,可以一直消费,每次消费一个
//3.面包店库存的上限为 100 个
public class SignalTest {

    //库存
    private static int SUM;

    public static void main(String[] args) {
        //五个面包师傅,同时启动
        for (int i = 0; i < 5; i++) {
            new Thread(()-> {
                try {
                    while (true) {
                        synchronized (SignalTest.class) {
                            if (SUM + 3 > 100) {
                                SignalTest.class.wait();
                            } else {
                                SUM += 3;
                                System.out.println(Thread.currentThread().getName() + "生产了面包,库存:" + SUM );
                                SignalTest.class.notify();
                            }
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },"面包师傅[" + i + "]").start();
        }

        //20个消费者,同时启动
        for (int i = 0; i < 20; i++) {
            new Thread(()-> {
                try {
                    while (true) {
                        synchronized (SignalTest.class) {
                            if (SUM == 0) {
                                SignalTest.class.wait();
                            } else {
                                SUM--;
                                System.out.println(Thread.currentThread().getName() + "消费了面包,库存:" + SUM );
                                SignalTest.class.notify();
                            }
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },"消费者[" + i + "]").start();
        }
    }
}
