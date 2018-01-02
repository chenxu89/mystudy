package timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer抛出异常缺陷：如果TimerTask抛出RuntimeException，Timer会终止所有任务的运行
 * Created by chenxu on 2017/12/5.
 */
public class TimerTest05 {
    private Timer timer;

    public TimerTest05(){
        this.timer = new Timer();
    }

    public void timerOne(){
        timer.schedule(new TimerTask() {
            public void run() {
                throw new RuntimeException();
            }
        }, 1000);
    }

    public void timerTwo(){
        timer.schedule(new TimerTask() {

            public void run() {
                System.out.println("我会不会执行呢？？");
            }
        }, 1000);
    }

    public static void main(String[] args) {
        TimerTest05 test = new TimerTest05();
        test.timerOne();
        test.timerTwo();
    }
}
