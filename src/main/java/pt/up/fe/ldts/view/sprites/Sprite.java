package pt.up.fe.ldts.view.sprites;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.File;
import java.net.URI;
import java.util.List;

public abstract class Sprite {

    protected int width, height;
    protected List<Character> spriteChars;

    public abstract void load(String resourcePath);
    public abstract void load(URI resourceURI);
    public abstract void load(File resourceFile);

    public abstract void render(TextGraphics tg);

}
