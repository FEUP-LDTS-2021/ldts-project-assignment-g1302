package pt.up.fe.ldts.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.model.employeeAI.EmployeeAI;
import pt.up.fe.ldts.model.employeeAI.ScatterAI;

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


    @Test
    public void ScatterTest(){

        EmployeeAI testAI = new ScatterAI();

        Employee toni, ze_castro, baltazar, mariana;

        toni = new Employee(10, 10, testAI, Employee.EmployeeName.TONI);

        ze_castro = new Employee(10,10,testAI, Employee.EmployeeName.ZE_CASTRO);

        baltazar = new Employee(10,10, testAI, Employee.EmployeeName.BALTAZAR);

        mariana = new Employee(10,10, testAI, Employee.EmployeeName.MARIANA);

        Assertions.assertEquals(10, toni.getX());
        Assertions.assertEquals(10, toni.getY());
        Assertions.assertEquals(Entity.Direction.LEFT, toni.getDirection());
        
        toni.changeDirection();
        ze_castro.changeDirection();
        baltazar.changeDirection();
        mariana.changeDirection();

        Assertions.assertEquals(Entity.Direction.LEFT, toni.getDirection());

        Assertions.assertEquals(Entity.Direction.DOWN, ze_castro.getDirection());

        Assertions.assertEquals(Entity.Direction.UP, baltazar.getDirection());

        Assertions.assertEquals(Entity.Direction.DOWN, mariana.getDirection());

    }
}
