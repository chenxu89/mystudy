package timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenxu on 2017/12/5.
 */
public class ScheduledExecutorTest2 {
    private ScheduledExecutorService scheduExec;

    public long start;

    ScheduledExecutorTest2(){
        this.scheduExec =  Executors.newScheduledThreadPool(2);
        this.start = System.currentTimeMillis();
    }

    public void timerOne(){
        scheduExec.schedule(new Runnable() {
            public void run() {
                throw new RuntimeException();
            }
        },1000, TimeUnit.MILLISECONDS);
    }

    public void timerTwo(){
        scheduExec.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("timerTwo invoked .....");
            }
        },2000,500,TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        ScheduledExecutorTest2 test = new ScheduledExecutorTest2();
        test.timerOne();
        test.timerTwo();
    }
}
