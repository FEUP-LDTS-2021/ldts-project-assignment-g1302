package pt.up.fe.ldts.view;

import pt.up.fe.ldts.view.gui.GUI;

import java.io.IOException;

public abstract class Viewer<T extends Drawable> {

    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return this.model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        render(gui);
        gui.refresh();
    }

    public abstract void render(GUI gui);
}
