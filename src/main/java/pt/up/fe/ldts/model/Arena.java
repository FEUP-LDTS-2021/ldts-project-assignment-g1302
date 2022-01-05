package pt.up.fe.ldts.model;

import pt.up.fe.ldts.view.Drawable;
import pt.up.fe.ldts.view.sprites.Sprite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class to handle visual elements of the game (mainly the game arena, the surface where every element is placed)
 */
public class Arena extends Drawable {

    private int width;
    private int height;

    List<Employee> employees;
    List<Wall> walls;
    List<Cerveja> cervejas;
    List<Tremoco> tremocos;

    public List<Employee> getEmployees() {
        return this.employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    public List<Wall> getWalls() { return this.walls; }
    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }
    public List<Cerveja> getCervejas() { return cervejas; }
    public void setCervejas(List<Cerveja> cervejas) {
        this.cervejas = cervejas;
    }
    public List<Tremoco> getTremocos() { return tremocos; }
    public void setTremocos(List<Tremoco> tremocos) {
        this.tremocos = tremocos;
    }

    /**
     * Constructor
     * @param width horizontal size of the game arena
     * @param height vertical size of the game arena
     */
    public Arena(int width, int height) {
        setWidth(width);
        setHeight(height);
        this.employees = new ArrayList<>(4);
        this.walls = new ArrayList<>();
        this.cervejas = new ArrayList<>();
        this.tremocos = new ArrayList<>();
    }

    /**
     * Get width of the arena
     * @return width of the arena
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set width of the arena
     * @param width new width value
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Get height of the arena
     * @return height of the arena
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set height of the arena
     * @param height new height value
     */
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    protected Sprite loadSprite() {
        return null; // the arena is going to be drawn differently
    }
}
