package timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenxu on 2017/12/5.
 */
public class ScheduledExecutorTest {
    private ScheduledExecutorService scheduExec;

    public long start;

    ScheduledExecutorTest(){
        this.scheduExec =  Executors.newScheduledThreadPool(2);
        this.start = System.currentTimeMillis();
    }

    public void timerOne(){
        scheduExec.schedule(new Runnable() {
            public void run() {
                System.out.println("timerOne,the time:" + (System.currentTimeMillis() - start) + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },1000, TimeUnit.MILLISECONDS);
    }

    public void timerTwo(){
        scheduExec.schedule(new Runnable() {
            public void run() {
                System.out.println("timerTwo,the time:" + (System.currentTimeMillis() - start) + Thread.currentThread().getName());
            }
        },2000,TimeUnit.MILLISECONDS);
    }

    public void timerThree(){
        scheduExec.schedule(new Runnable() {
            public void run() {
                System.out.println("timerThree,the time:" + (System.currentTimeMillis() - start) + Thread.currentThread().getName());
            }
        },4000,TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        ScheduledExecutorTest test = new ScheduledExecutorTest();
        test.timerOne();
        test.timerTwo();
        test.timerThree();
    }
}
