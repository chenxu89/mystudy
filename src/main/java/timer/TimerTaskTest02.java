package timer;

import java.util.TimerTask;

/**
 * Created by chenxu on 2017/12/4.
 */
public class TimerTaskTest02 extends TimerTask {

    @Override
    public void run() {
        System.out.println("指定时间执行线程任务...");
    }
}
