package threadPool;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池使用示例, 主线程等待所有任务完成再结束.
 * @author chenlb 2008-12-2 上午10:31:03
 */
public class ThreadPoolUseTwo {

    public static class MyTask implements Runnable {
        private static int id = 0;

        private String name = "task-" + (++id);
        private int sleep;

        public MyTask(int sleep) {
            super();
            this.sleep = sleep;
        }

        public void run() {
            System.out.println(name + " -----start-----");
            try {
                Thread.sleep(sleep);    //模拟任务执行.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " -----end " + sleep + "-----");
        }
    }

    public static class MyFatherTask extends TimerTask {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        @Override
        public void run() {
            long num = executor.getTaskCount() - executor.getCompletedTaskCount();
            System.out.println(executor + " TaskCount = " + executor.getTaskCount() + " 剩余任务数目 = " + num);
            if (num == 0) {
                System.out.println("==================start add new task==================" + new Date());
                for (int i = 0; i < 10; i++) {
                    executor.execute(new MyTask(1000));
                }
            }
        }
    }


    public static void main(String[] args) {
        final Timer timer = new Timer("mytimer");
        timer.schedule(new MyFatherTask(), 0, 1000);
//        try {
//            Thread.sleep(99999999999L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
