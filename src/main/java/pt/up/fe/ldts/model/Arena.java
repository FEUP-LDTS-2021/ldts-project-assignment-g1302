package pt.up.fe.ldts.model;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import groovyjarjarantlr4.v4.runtime.atn.EpsilonTransition;
import pt.up.fe.ldts.view.Drawable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class to handle visual elements of the game (mainly the game arena, the surface where every element is placed)
 */
public class Arena implements Drawable {

    private int width;
    private int height;

    private final List<Employee> employees = new ArrayList<>();
    private final List<Wall> walls = new ArrayList<>();
    private final List<Collectible> collectibles = new ArrayList<>();

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void addEmployees(List<Employee> employees) {
        this.employees.addAll(employees);
    }
    public void addWalls(List<Wall> walls) {
        this.walls.addAll(walls);
    }
    public void addCollectibles(List<Collectible> collectibles) {
        this.collectibles.addAll(collectibles);
    }

    /**
     * Constructor
     * @param width horizontal size of the game arena
     * @param height vertical size of the game arena
     */
    public Arena(int width, int height){
        setWidth(width);
        setHeight(height);
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

    public Set<Vector> getValidDirections(Point position, Vector currentDirection, boolean isJorge) {
        Set<Vector> validDirs = new HashSet<>(List.of(Vector.UP, Vector.LEFT, Vector.DOWN, Vector.RIGHT));

        return validDirs
                .stream()
                .filter(dir -> isJorge || !dir.equals(currentDirection.multiply(-1)))
                .filter(dir -> {
                    var newPosition = position.addVector(dir);

                    return !this.walls.contains(new Wall(newPosition.getX(), newPosition.getY()));
                })
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public void render(TextGraphics tg) {

        tg.setBackgroundColor(TextColor.Factory.fromString(TextColor.ANSI.BLACK.name()));
        tg.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        for (var wall : this.walls)
            wall.render(tg);

        for (var collectible : this.collectibles)
            collectible.render(tg);

        for (var employee : this.employees)
            employee.render(tg);

        Jorge.singleton.render(tg); // make Jorge the last element to be rendered on screen so the score always appears on top
    }
}
