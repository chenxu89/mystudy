package powermock;

import com.google.common.annotations.VisibleForTesting;

/**
 * Created by chenxu on 2017/12/3.
 */
public class ClassUnderTest {

    public static void main(String[] args) {

        ClassUnderTest test = new ClassUnderTest();
        System.out.println(test.testprivate2());
    }

    public int entry() {
        return testprivate();
    }


    public static int teststatic() {
        return 0;
    }

    public static int teststatic1(int i) {
        return i;
    }

    public final int testfinal() {
        return 0;
    }
    private int testprivate(){
        return 0;
    }
    @VisibleForTesting
    public int testprivate2(){
        return 0;
    }



}
