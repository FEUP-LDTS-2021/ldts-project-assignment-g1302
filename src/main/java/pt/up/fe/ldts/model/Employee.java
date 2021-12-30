package pt.up.fe.ldts.model;

import pt.up.fe.ldts.model.employeeAI.EmployeeAI;
import pt.up.fe.ldts.model.employeeAI.FrightenedAI;

public class Employee extends Entity implements CervejaListener {

    private static int SCORE_WHEN_EATEN = 20;

    public enum EmployeeName {
        TONI,
        ZE_CASTRO,
        BALTAZAR,
        MARIANA
    }

    public enum EmployeeState{
        FRIGHTENED,
        SCATTER,
        CHASING,
        DEAD
    }

    private EmployeeAI ai;
    private EmployeeName name;
    private EmployeeState state = EmployeeState.SCATTER;

    public Employee(int x, int y, EmployeeAI ai, EmployeeName name) {
        super(x, y);
        this.ai = ai;
        this.name = name;
    }

    public EmployeeState getCurrentState() {
        return this.state;
    }

    public void setCurrentState(EmployeeState newState) {
        this.state = newState;
    }

    @Override
    public void cervejaPicked() {
        this.setCurrentState(EmployeeState.FRIGHTENED);

        var currentAi = this.ai;
        this.ai = FrightenedAI.singleton;

        //TODO: implement timer

        this.ai = currentAi;
    }

    @Override
    public void changeDirection() {
        this.setDirection(this.ai.chooseTargetDirection(this.getCurrentState()));
    }
}
