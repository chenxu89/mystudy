package timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by chenxu on 2017/12/4.
 */
public class TimerTaskTest03 extends TimerTask {

    @Override
    public void run() {
        Date date = new Date(this.scheduledExecutionTime());
        System.out.println("本次执行该线程的时间为：" + date);
    }
}
