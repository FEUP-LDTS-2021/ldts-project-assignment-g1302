package pt.up.fe.ldts.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import pt.up.fe.ldts.view.gui.GUI;

public abstract class Viewer<T extends Drawable> {

    private T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return this.model;
    }

    public abstract void render(GUI gui, TextGraphics graphics);
}
