package pt.up.fe.ldts.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import pt.up.fe.ldts.model.Jorge;

public class JorgeViewer extends Viewer<Jorge> {

    public JorgeViewer() {
        super(Jorge.singleton);
    }

    @Override
    public void render(TextGraphics graphics) {

        //TODO: print the model


        graphics.putString(2, 1, "Score: " + this.getModel().getScore());


    }
}
