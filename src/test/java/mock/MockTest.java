package mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

/**
 * Created by chenxu on 2017/12/2.
 */
public class MockTest {
    public static void main(String[] args) {

    }

    @BeforeMethod
    public void name() throws Exception {
//        LinkedList mockedList = mock(LinkedList.class);
    }


    @Test
    public void test1() throws Exception {
//        System.out.println(mo.get(0));

//        when(mo.get(0)).thenReturn("first");
//        System.out.println(mo.get(0));

//        when(mo.get(1)).thenThrow(new RuntimeException());
//        System.out.println(mo.get(1));

//        doThrow(new RuntimeException("clear exception")).when(mo).clear();
//        mo.clear();

//        when(mo.get(anyInt())).thenReturn("element");
//        System.out.println(mo.get(999));

//        mo.add("once");
//        mo.add("once");
//        verify(mo).add("once");
//        verify(mo, times(2)).add("once");

//        mo.add("one");
//        mo.clear();
//        verify(mo).add("one");
//        verify(mo).clear();

    }

    @Test
    public void test2() throws Exception {

        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);
        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        //following prints "first"
        System.out.println(mockedList.get(0));
        //following throws runtime exception
//        System.out.println(mockedList.get(1));
        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        verify(mockedList).get(0);
    }

    @Test
    public void test3() throws Exception {
//        LinkedList mockedList = mock(LinkedList.class);
//        //stubbing using built-in anyInt() argument matcher
//        when(mockedList.get(anyInt())).thenReturn("element");
//        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
//        when(mockedList.contains(argThat(isValid()))).thenReturn("element");
//        //following prints "element"
//        System.out.println(mockedList.get(999));
//        //you can also verify using an argument matcher
//        verify(mockedList).get(anyInt());
//        //argument matchers can also be written as Java 8 Lambdas
//        verify(mockedList).add(someString -> someString.length() > 5);
    }
}
