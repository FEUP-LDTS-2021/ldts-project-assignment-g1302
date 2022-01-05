package pt.up.fe.ldts.view;

import pt.up.fe.ldts.model.Arena;
import pt.up.fe.ldts.model.Element;
import pt.up.fe.ldts.model.Jorge;
import pt.up.fe.ldts.view.gui.GUI;

import java.util.List;

public class ArenaViewer extends Viewer<Arena> {

    public ArenaViewer(Arena model) {
        super(model);
    }

    @Override
    public void render(GUI gui) {

        this.drawElement(gui, Jorge.singleton, new JorgeViewer());
        this.drawElements(gui, this.getModel().getEmployees(), new EmployeeViewer());
        this.drawElements(gui, this.getModel().getWalls(), new WallViewer());
        this.drawElements(gui, this.getModel().getTremocos(), new TremocoViewer());
        this.drawElements(gui, this.getModel().getCervejas(), new CervejaViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.render(element, gui);
    }
}
