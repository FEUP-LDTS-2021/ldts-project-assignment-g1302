package pt.up.fe.ldts.model;

public class Jorge extends Entity{

    private Jorge(int x, int y) {
        super(x, y);
    }

    public static Jorge jorge = new Jorge(4,5);

    @Override
    public void changeDirection() {
        // change direction based on keystrokes
    }


}
