package pt.up.fe.ldts.view;

import pt.up.fe.ldts.view.sprites.Sprite;

import java.io.Serializable;

/**
 * Interface to mark a class as drawable, so it can be used in a view by a dedicated Viewer.
 */
public abstract class Drawable {
    protected Sprite s;

    protected Drawable(Sprite s){
        this.s = s;
    }

    public Sprite getSprite() {
        return this.s;
    }
}
