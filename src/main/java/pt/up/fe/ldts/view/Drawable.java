package pt.up.fe.ldts.view;

import pt.up.fe.ldts.view.sprites.Sprite;

import java.io.Serializable;

/**
 * Interface to mark a class as drawable, so it can be used in a view by a dedicated Viewer.
 */
public abstract class Drawable {
    protected Sprite s;

    protected Drawable(){
        this.s = this.loadSprite();
    }

    public Sprite getSprite() {
        return this.s;
    }

    protected abstract Sprite loadSprite();
}
