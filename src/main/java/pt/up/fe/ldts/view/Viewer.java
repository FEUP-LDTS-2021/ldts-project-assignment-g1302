package pt.up.fe.ldts.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import pt.up.fe.ldts.model.Element;

public abstract class Viewer<T extends Element> {

    private T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return this.model;
    }

    public abstract void render(TextGraphics graphics);
}
