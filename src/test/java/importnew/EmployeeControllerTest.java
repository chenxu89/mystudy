package importnew;

/**
 * Created by chenxu on 2017/12/3.
 */
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import static org.powermock.api.mockito.PowerMockito.*;
import static org.testng.Assert.assertEquals;

public class EmployeeControllerTest {

    @Test
    public void shouldReturnProjectedCountOfEmployeesFromTheService() {
        // 注意如果要mock一个方法的返回值，必须先mock这个方法的对象，否则就会调用真实的方法
//        EmployeeService mock = PowerMockito.mock(EmployeeService.class);
        EmployeeService mock = new EmployeeService();
        PowerMockito.when(mock.getEmployeeCount()).thenReturn(8);
        EmployeeController employeeController = new EmployeeController(mock);
        assertEquals(10, employeeController.getProjectedEmployeeCount());
    }

    @Test
    public void
    shouldInvokeSaveEmployeeOnTheServiceWhileSavingTheEmployee() {

        EmployeeService mock = PowerMockito.mock(EmployeeService.class);
        EmployeeController employeeController = new EmployeeController(mock);
        Employee employee = new Employee();
        employeeController.saveEmployee(employee);
        Mockito.verify(mock).saveEmployee(employee);
    }
}