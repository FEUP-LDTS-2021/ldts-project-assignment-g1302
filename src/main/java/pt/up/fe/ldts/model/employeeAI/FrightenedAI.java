package pt.up.fe.ldts.model.employeeAI;

import pt.up.fe.ldts.model.Element;
import pt.up.fe.ldts.model.Employee;

public class FrightenedAI implements EmployeeAI {

    private FrightenedAI() {}

    public static FrightenedAI singleton = new FrightenedAI();

    @Override
    public Element.Position chooseTarget(Employee.EmployeeName name) {
        return null;
    }

}
