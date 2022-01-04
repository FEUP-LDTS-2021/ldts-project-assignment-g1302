package pt.up.fe.ldts.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import pt.up.fe.ldts.model.Jorge;
import pt.up.fe.ldts.model.Point;
import pt.up.fe.ldts.view.gui.GUI;

public class JorgeViewer extends Viewer<Jorge> {

    public JorgeViewer() {
        super(Jorge.singleton);
    }

    @Override
    public void render(GUI gui) {

        //TODO: print the model

        gui.drawText(new Point(2, 1), "Score: " + this.getModel().getScore(), null);
    }
}
