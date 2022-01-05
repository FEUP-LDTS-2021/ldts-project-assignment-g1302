package pt.up.fe.ldts.view.gui;

import pt.up.fe.ldts.model.Element;
import pt.up.fe.ldts.model.Point;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawJorge();

    void drawWall(Point point);

    void drawEmployee(Point point, String color);

    void drawText(Point point, String text, String color);

    void drawTremoco(Point point);

    void drawCerveja(Point point);

    void drawElement(Element element);

    void drawCharacter(int x, int y, char c, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}