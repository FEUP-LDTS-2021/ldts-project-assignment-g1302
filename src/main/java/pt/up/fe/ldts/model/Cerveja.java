package pt.up.fe.ldts.model;

import pt.up.fe.ldts.view.sprites.Sprite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cerveja extends Collectible {

    static {
        Cerveja.POINTS_PER_ITEM = 20;
    }

    private List<CervejaListener> listeners;

    public void addListener(CervejaListener listener) {
        this.listeners.add(listener);
    }

    /**
     * Constructs a new Cerveja on the given position
     * @param x the x coordinate of this Cerveja
     * @param y the y coordinate of this Cerveja
     */
    public Cerveja(int x, int y){
        super(x,y);
        this.listeners = new ArrayList<>(); // better for traversal
    }

    @Override
    public void notifyCollected() {

        //TODO: when that is implemented, add score to Jorge
        this.listeners.forEach(CervejaListener::cervejaPicked);
    }

    @Override
    protected Sprite loadSprite() {
        return new Sprite(1, 1, Arrays.asList('I'));
    }
}
