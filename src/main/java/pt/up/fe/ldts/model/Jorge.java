package pt.up.fe.ldts.model;

import pt.up.fe.ldts.view.sprites.Sprite;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Jorge extends Entity{

    public static Jorge singleton = new Jorge(4, 5); // to be changed later

    private final AtomicInteger score = new AtomicInteger(0);

    /**
     * Constructs a new Jorge on the given position
     * @param x the x coordinate of this Jorge
     * @param y the y coordinate of this Jorge
     */
    private Jorge(int x, int y) {
        super(x, y);
    }

    @Override
    public void changeDirection() {
        // change direction based on keystrokes
    }

    public synchronized void addScore(int points) {
        score.getAndAdd(points);
    }

    public synchronized int getScore() {
        return score.get();
    }

    @Override
    protected Sprite loadSprite() {
        return new Sprite(1, 1, Arrays.asList('J'));
    }
}
