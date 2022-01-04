package pt.up.fe.ldts.model;

import pt.up.fe.ldts.view.Drawable;
import pt.up.fe.ldts.view.sprites.Sprite;

/**
 * Class to handle visual elements of the game (mainly the game arena, the surface where every element is placed)
 */
public class Arena extends Drawable {

    private int width;
    private int height;

    private static Sprite getArenaSprite() {
        return null;
    }

    /**
     * Constructor
     * @param width horizontal size of the game arena
     * @param height vertical size of the game arena
     */
    public Arena(int width, int height){
        super(Arena.getArenaSprite());
        setWidth(width);
        setHeight(height);
    }

    /**
     * Get width of the arena
     * @return width of the arena
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set width of the arena
     * @param width new width value
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Get height of the arena
     * @return height of the arena
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set height of the arena
     * @param height new height value
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
