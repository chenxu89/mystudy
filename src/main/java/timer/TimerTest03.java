package timer;

import java.util.Timer;

/**
 * 在延迟指定时间后以指定的间隔时间循环执行定时任务
 * Created by chenxu on 2017/12/4.
 */
public class TimerTest03 {
    Timer timer;

    public TimerTest03(){
        timer = new Timer();
        // delay 不能为负数
        timer.schedule(new TimerTaskTest03(), 1000, 500);
    }

    public static void main(String[] args) {
        new TimerTest03();
    }
}