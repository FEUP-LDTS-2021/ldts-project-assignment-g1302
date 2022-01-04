package pt.up.fe.ldts.model;

import pt.up.fe.ldts.view.sprites.Sprite;

public abstract class Element {

    private Point position;
    private Sprite sprite;

    /**
     * Constructs a new Element on the given position
     *
     * @param x the x coordinate of this entity
     * @param y the y coordinate of this entity
     */
    public Element(int x, int y, Sprite s){
        this.position = new Point(x,y);
        this.sprite = s;
    }

    /**
     * Get the position of an Element as a Point
     * @return Point representing this element's position
     */
    public Point getPosition() {
        return this.position;
    }

    /**
     * Get x coordinate of an Element
     * @return x coordinate of this element
     */
    public int getX() {
        return this.getPosition().getX();
    }

    /**
     * Get y coordinate of an Element
     * @return y coordinate of this element
     */
    public int getY() {
        return this.getPosition().getY();
    }

    /**
     * Returns the sprite used to render this element.
     *
     * @return the sprite used to render this element
     */
    public Sprite getSprite() {
        return sprite;
    }
}
