package pt.up.fe.ldts.view.element;

import pt.up.fe.ldts.model.Element;
import pt.up.fe.ldts.view.gui.GUI;

public interface ElementViewer<T extends Element> {
    void render(T element, GUI gui);
}
