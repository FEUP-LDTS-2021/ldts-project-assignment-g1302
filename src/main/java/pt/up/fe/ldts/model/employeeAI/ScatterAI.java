package pt.up.fe.ldts.model.employeeAI;

import pt.up.fe.ldts.model.Element;
import pt.up.fe.ldts.model.Employee;

public class ScatterAI implements EmployeeAI{

    public ScatterAI(){}


    //valores default pra cantos enquanto não sabemos as medidas do mapa
    public Element.Position chooseTarget(Employee.EmployeeName name){
        switch (name){
            case TONI -> {
                return new Element.Position(0, 0);
            }
            case ZE_CASTRO -> {
                return new Element.Position(0,20);
            }
            case BALTAZAR -> {
                return new Element.Position(20,0);
            }
            case MARIANA -> {
                return new Element.Position(20,20);
            }
        }
        return null;
    }

}
