package pt.up.fe.ldts.view.element;

import pt.up.fe.ldts.model.Employee;
import pt.up.fe.ldts.view.gui.GUI;

public class EmployeeViewer implements ElementViewer<Employee> {

    @Override
    public void render(Employee element, GUI gui) {
        gui.drawEmployee(element.getPosition(), "");
    }
}
