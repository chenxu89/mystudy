package powermock;

import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by chenxu on 2017/12/3.
 */
@PrepareForTest(ClassUnderTest.class)
public class MyTestClass extends PowerMockTestCase {
    // 下面这个方法和extends PowerMockTestCase 二选一
//    @ObjectFactory
//    public IObjectFactory getObjectFactory() {
//        return new org.powermock.modules.testng.PowerMockObjectFactory();
//    }

    @Test
    public void demoStaticMethodMocking() throws Exception {
        mockStatic(ClassUnderTest.class);
        when(ClassUnderTest.teststatic()).thenReturn(1);
        new ClassUnderTest().teststatic();
        // Optionally verify that the static method was actually called
        verifyStatic(ClassUnderTest.class);
        ClassUnderTest.teststatic();
    }

    @Test
    public void demoPrivateMethodMocking() throws Exception {
        ClassUnderTest underTest = spy(new ClassUnderTest());
        String name = "testprivate";
        when(underTest, name).thenReturn(3);
        Assert.assertEquals(underTest.entry(), 3);
        verifyPrivate(underTest).invoke(name);
    }

    @Test
    public void testName() throws Exception {
        mockStatic(ClassUnderTest.class);
        when(ClassUnderTest.teststatic1(1)).thenReturn(2);
        Assert.assertEquals(ClassUnderTest.teststatic1(1), 2);
        verifyStatic(ClassUnderTest.class, Mockito.times(2));
        ClassUnderTest.teststatic1(1);
        verifyStatic(ClassUnderTest.class, Mockito.times(2));
        ClassUnderTest.teststatic1(1);
//        Assert.assertEquals(ClassUnderTest.teststatic1(1), 2);
//        Assert.assertEquals(ClassUnderTest.teststatic1(1), 2);
    }
}
