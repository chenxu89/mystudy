package timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 测试scheduleAtFixedRate，比较其与schedule的区别
 * Created by chenxu on 2017/12/5.
 */
public class TimerTest06 {
    private Timer timer;
    public long start;

    public TimerTest06(){
        this.timer = new Timer();
        start = System.currentTimeMillis();
    }

    public void timerScheduleAtFixedRate(){

        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 0;
            public void run() {
                System.out.println("timerOne invoked ,the time:" + (System.currentTimeMillis() - start));
                i++;
                if (i == 1) {
                    try {
                        Thread.sleep(2000);    //线程休眠2000
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 0, 1000);
    }
    public void timerSchedule(){
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("timerOne invoked ,the time:" + (System.currentTimeMillis() - start));
                try {
                    Thread.sleep(2000);    //线程休眠2000
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1000);
    }

    public static void main(String[] args) throws Exception {
        TimerTest06 test = new TimerTest06();

        /*执行结果如下，注意第二行和第三行
        timerOne invoked ,the time:0
        timerOne invoked ,the time:2002
        timerOne invoked ,the time:2002
        timerOne invoked ,the time:3002
        timerOne invoked ,the time:4002*/
        test.timerScheduleAtFixedRate();

        /*执行结果如下，注意第二行和第三行
        timerOne invoked ,the time:1
        timerOne invoked ,the time:2003
        timerOne invoked ,the time:4006
        timerOne invoked ,the time:6007*/
//        test.timerSchedule();
    }

    /*
    * 区别总结：参考官方文档
    *
    * */
}
