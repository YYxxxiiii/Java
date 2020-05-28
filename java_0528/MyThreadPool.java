package java_0528;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class MyThreadPool {

    private BlockingQueue<Runnable> queue;//仓库：可以使用自定义的阻塞队列

    //创建快递公司
    public MyThreadPool(int corePoolSize, int capacity){
        //创建仓库
        queue = new ArrayBlockingQueue<>(capacity);
        //招聘员工
        for(int i=0; i<corePoolSize; i++){
            new MyThread(queue).start();
        }
    }
    //快递公司开放出来送快递的接口（电话、营业点）：
    // 客户调用接口（打电话，去营业点办业务）。快递包裹存放在仓库中
    public void execute(Runnable task){
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //正式员工：一直干活
    private static class MyThread extends Thread{
        private BlockingQueue<Runnable> queue;
        public MyThread(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            try {
                //员工不停的从仓库取包裹，没有取到就阻塞等待，取到就执行
                while (true){
                    Runnable task = queue.take();
                    task.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
