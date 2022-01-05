package pt.up.fe.ldts.view.element;

import pt.up.fe.ldts.model.Jorge;
import pt.up.fe.ldts.model.Point;
import pt.up.fe.ldts.view.gui.GUI;

public class JorgeViewer implements ElementViewer<Jorge> {

    @Override
    public void render(Jorge element, GUI gui) {

        //TODO: print the model
        gui.drawJorge();
        gui.drawText(new Point(2, 1), "Score: " + element.getScore(), null);
    }
}
