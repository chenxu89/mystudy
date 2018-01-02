import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenxu on 2017/12/11.
 */
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    @org.testng.annotations.Test
    public void test1() throws Exception {
        //Sting或Date转换为时间戳
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String begin = "2017-12-12 19:00:00";
        String end = "2017-12-12 21:00:00";
        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = format.parse(begin);
            endDate = format.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long beginDateTime = beginDate.getTime()/1000;
        long endDateTime = endDate.getTime()/1000;
        System.out.println(beginDateTime);
        System.out.println(endDateTime);
    }

    @org.testng.annotations.Test
    public void test2() throws Exception {
        //时间戳转化为Sting或Date
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long stamp = 1513002420l;
        Date date = new Date(stamp * 1000);
        String d = format.format(date);
        System.out.println(d);
//        Long l = new Long(12031l);
//
//        System.out.println(l == 12031l);
    }

    @org.testng.annotations.Test
    public void test3() throws Exception {
        String s = null;
        Assert.assertEquals(s+"1", "null1");
    }

    @org.testng.annotations.Test
    public void test4() throws Exception {
        String rowkey = "my rowkey";
        try {
            throw new IOException();
        } catch (IOException io) {
            logger.error("fail to saveLastPredMaxMinLongTermAndPredMaxMinInLastWindowtoPesistence for rowkey: {} cool", rowkey, io);
        }
    }
}

