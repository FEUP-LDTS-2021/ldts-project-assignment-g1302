package pt.up.fe.ldts.model;

import pt.up.fe.ldts.view.sprites.Sprite;

public class Tremoco extends Collectible {

    static {
        Tremoco.POINTS_PER_ITEM = 10;
    }

    /**
     * Constructs a new Tremoco on the given position
     * @param x the x coordinate of this Tremoço
     * @param y the x coordinate of this Tremoço
     */
    public Tremoco(int x, int y){
        super(x,y);
    }

    @Override
    public void notifyCollected() {

        //TODO: when that is implemented, add score to Jorge

    }

    @Override
    protected Sprite loadSprite() {
        return null;
    }
}
