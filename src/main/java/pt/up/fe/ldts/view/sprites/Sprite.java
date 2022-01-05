package pt.up.fe.ldts.view.sprites;

import pt.up.fe.ldts.model.Point;
import pt.up.fe.ldts.view.gui.GUI;

import java.util.List;

public class Sprite {

    protected int width, height;
    protected List<Character> spriteChars;

    public Sprite(int width, int height, List<Character> spriteChars) {
        this.width = width;
        this.height = height;
        this.spriteChars = spriteChars;
    }

    public void render(GUI gui, Point position) {
        for (int y = 0; y < this.height; y++) {
            int actualY = position.getY() + y;
            for (int x = 0; x < this.width; x++) {
                int actualX = position.getX() + x;
                int index = x + y*this.width;
                gui.drawCharacter(actualX, actualY, this.spriteChars.get(index), "");
            }
        }
    };
}
