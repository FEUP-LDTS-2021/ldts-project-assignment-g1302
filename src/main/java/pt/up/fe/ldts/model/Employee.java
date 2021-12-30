package pt.up.fe.ldts.model;

import pt.up.fe.ldts.model.employeeAI.EmployeeAI;
import pt.up.fe.ldts.model.employeeAI.FrightenedAI;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

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


    //refactor later
    @Override
    public void changeDirection() {
        double frontDistance, leftDistance, rightDistance;
        int newX, newY;

        Element.Position target = this.ai.chooseTarget(this.name);

        //this doesn't account for walls

        switch (this.getDirection()){
            case UP -> {
                //keep going same direction

                newX = this.getX();
                newY = this.getY()-1;

                frontDistance = sqrt(pow(target.getX() - newX , 2) + pow(target.getY() - newY, 2));

                //turn left

                newX = this.getX() -1;
                newY = this.getY();

                leftDistance =  sqrt(pow(target.getX() - newX , 2) + pow(target.getY() - newY, 2));

                //turn right

                newX = this.getX() +1;
                newY = this.getY();

                rightDistance =  sqrt(pow(target.getX() - newX , 2) + pow(target.getY() - newY, 2));

                if(frontDistance < leftDistance){
                    if (frontDistance > rightDistance)
                        this.setDirection(Direction.RIGHT);
                }
                else {
                    if (leftDistance < rightDistance)
                        this.setDirection(Direction.LEFT);
                    else
                        this.setDirection(Direction.RIGHT);
                }

            }
            case DOWN -> {


                newX = this.getX();
                newY = this.getY()+1;

                frontDistance = sqrt(pow(target.getX() - newX , 2) + pow(target.getY() - newY, 2));



                newX = this.getX() +1;
                newY = this.getY();

                leftDistance =  sqrt(pow(target.getX() - newX , 2) + pow(target.getY() - newY, 2));



                newX = this.getX() -1;
                newY = this.getY();

                rightDistance =  sqrt(pow(target.getX() - newX , 2) + pow(target.getY() - newY, 2));

                if(frontDistance < leftDistance){
                    if (frontDistance > rightDistance)
                        this.setDirection(Direction.LEFT);
                }
                else {
                    if (leftDistance < rightDistance)
                        this.setDirection(Direction.RIGHT);
                    else
                        this.setDirection(Direction.LEFT);
                }
            }
            case RIGHT -> {


                newX = this.getX() + 1;
                newY = this.getY();

                frontDistance = sqrt(pow(target.getX() - newX , 2) + pow(target.getY() - newY, 2));



                newX = this.getX();
                newY = this.getY() - 1;

                leftDistance =  sqrt(pow(target.getX() - newX , 2) + pow(target.getY() - newY, 2));



                newX = this.getX();
                newY = this.getY() + 1;

                rightDistance =  sqrt(pow(target.getX() - newX , 2) + pow(target.getY() - newY, 2));

                if(frontDistance < leftDistance){
                    if (frontDistance > rightDistance)
                        this.setDirection(Direction.DOWN);
                }
                else {
                    if (leftDistance < rightDistance)
                        this.setDirection(Direction.UP);
                    else
                        this.setDirection(Direction.DOWN);
                }
            }
            case LEFT -> {

                newX = this.getX() - 1;
                newY = this.getY();

                frontDistance = sqrt(pow(target.getX() - newX , 2) + pow(target.getY() - newY, 2));


                newX = this.getX();
                newY = this.getY() + 1;

                leftDistance =  sqrt(pow(target.getX() - newX , 2) + pow(target.getY() - newY, 2));


                newX = this.getX();
                newY = this.getY() - 1;

                rightDistance =  sqrt(pow(target.getX() - newX , 2) + pow(target.getY() - newY, 2));

                if(frontDistance < leftDistance){
                    if (frontDistance > rightDistance)
                        this.setDirection(Direction.UP);
                }
                else {
                    if (leftDistance < rightDistance)
                        this.setDirection(Direction.DOWN);
                    else
                        this.setDirection(Direction.UP);
                }
            }
        }
    }
}
