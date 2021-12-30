package pt.up.fe.ldts.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.model.employeeAI.EmployeeAI;

import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeTest {

    @Test
    public void testConstrction() {

        Employee employee = new Employee(4, 5, null, null);

        Assertions.assertEquals(4, employee.getX());
        Assertions.assertEquals(5, employee.getY());

        Assertions.assertEquals(Employee.EmployeeState.SCATTER, employee.getCurrentState());
    }

    @Test
    public void testNotifiable() {

        Employee employee;

        AtomicInteger test = new AtomicInteger(0);

        EmployeeAI testAI = Mockito.mock(EmployeeAI.class);
        Mockito.when(testAI.chooseTarget(Mockito.any())).thenAnswer(invocation -> {
            test.set(1);
            return new Element.Position(4, 7);
        });

        employee = new Employee(4, 5, testAI, null);

        employee.changeDirection();

        Mockito.verify(testAI, Mockito.times(1)).chooseTarget(Mockito.any());
        Assertions.assertEquals(1, test.get());
        Assertions.assertEquals(Entity.Direction.DOWN, employee.getDirection());
    }
}
