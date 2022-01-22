package pt.up.fe.ldts.model.map;

import pt.up.fe.ldts.controller.employeeAI.BaltaAI;
import pt.up.fe.ldts.controller.employeeAI.MariAI;
import pt.up.fe.ldts.controller.employeeAI.ToniAI;
import pt.up.fe.ldts.controller.employeeAI.ZeCastroAI;
import pt.up.fe.ldts.model.*;
import pt.up.fe.ldts.model.game.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FileLoadedMap implements Map {

    private final int width, height, boxWidth, boxHeight;

    private final List<Wall> walls;
    private final List<Employee> employees;
    private final List<Collectible> collectibles;

    private Point gatePosition; // can't be final since it is initialized in a switch statement ,so it might not happen
    private Point baltaPos, zePos, toniPos, mariPos, jorgePos;
    private final Point boxPosition /*top left corner of ghost box*/;

    public FileLoadedMap(String mapName) throws Exception {
        URL resource = getClass().getClassLoader().getResource("maps/" + mapName + ".map");

        if (resource == null) {

            throw new Exception("Map file not found: " + mapName + ".map");
        }

        File mapFile = new File(resource.toURI());
        BufferedReader br = new BufferedReader(new FileReader(String.valueOf(mapFile.toPath()), Charset.defaultCharset()));


        walls = new ArrayList<>();
        employees = new ArrayList<>();
        collectibles = new ArrayList<>();

        String str = br.readLine();
        String[] sr = str.split("X");

        width = Integer.parseInt(sr[0]);
        if (width < 0) {
            throw new Exception("Negative width: " + width + " - " + mapName + ".map");
        }

        height = Integer.parseInt(sr[1]);
        if (height < 0) {
            throw new Exception("Negative height: " + height + " - " + mapName + ".map");
        }

        for(int y = 0; y < this.height; y++){
            str = br.readLine();

            if(str.length() != width){
                throw new Exception(mapName + ".map: " + "Expected line with width: " + width + ", instead got: " + str.length() + " - " + str);
            }

            for(int x = 0; x < this.width; x++){
                switch (str.charAt(x)){
                    case 'W' -> walls.add(new Wall(x,y));
                    case 't' -> collectibles.add(new Tremoco(x,y));
                    case 'C' -> collectibles.add(new Cerveja(x,y));
                    case 'J' -> jorgePos = new Point(x, y);
                    case 'G' -> gatePosition = new Point(x,y);
                    case 'B' -> baltaPos = new Point(x,y);
                    case 'Z' -> zePos = new Point(x,y);
                    case 'M' -> mariPos = new Point(x,y);
                    case 'T' -> toniPos = new Point(x,y);
                }
            }
        }

        str = br.readLine();
        sr = str.split(",");

        boxPosition = new Point(Integer.parseInt(sr[0]), Integer.parseInt(sr[1]));

        if (boxPosition.getX() < 0 || boxPosition.getY() < 0){
            throw new Exception("Invalid box position: (" + boxPosition.getX() + "," + boxPosition.getY() + ") - " + mapName + ".map");
        }

        str = br.readLine();
        sr = str.split("X");

        boxWidth = Integer.parseInt(sr[0]);

        if (boxWidth < 0){
            throw new Exception("Negative box width: " + boxWidth + " - " + mapName + ".map");
        }
        boxHeight = Integer.parseInt(sr[1]);

        if (boxHeight < 0){
            throw new Exception("Negative box height: " + boxHeight + " - " + mapName + ".map");
        }

        if (baltaPos != null && isNotInsideBox(baltaPos)){
            throw new Exception("Employee outside box: Balta" + " - " + mapName + ".map");
        }

        if (toniPos != null && isNotInsideBox(toniPos)){
            throw new Exception("Employee outside box: Toni" + " - " + mapName + ".map");
        }

        if (mariPos != null && isNotInsideBox(mariPos)){
            throw new Exception("Employee outside box: Mari" + " - " + mapName + ".map");
        }

        if (zePos != null && isNotInsideBox(zePos)){
            throw new Exception("Employee outside box: ZeCastro" + " - " + mapName + ".map");
        }

        if(zePos != null && baltaPos == null){
            throw new Exception("ZeCastro can't exist without Balta - " + mapName + ".map");
        }
        MapConfiguration.setMapHeight(height);
        MapConfiguration.setMapWidth(width);
        MapConfiguration.setGatePosition(gatePosition);
        MapConfiguration.setCollectibles(collectibles);

        if (baltaPos != null)
            employees.add(new Employee(baltaPos.getX(), baltaPos.getY(), new BaltaAI()));
        if (zePos != null)
            employees.add(new Employee(zePos.getX(), zePos.getY(), new ZeCastroAI(employees.get(0))));
        if (mariPos != null)
            employees.add(new Employee(mariPos.getX(), mariPos.getY(), new MariAI()));
        if (toniPos != null)
            employees.add(new Employee(toniPos.getX(), toniPos.getY(), new ToniAI()));
        if (jorgePos != null) {
            Jorge.singleton.changePos(jorgePos.getX(), jorgePos.getY());
            MapConfiguration.setJorgePosition(jorgePos);
        }
    }

    private boolean isNotInsideBox(Point position) {

        boolean insideWidth = this.boxPosition.getX() <= position.getX() && position.getX() < this.boxPosition.getX() + this.boxWidth;
        boolean insideHeight = this.boxPosition.getY() <= position.getY() && position.getY() < this.boxPosition.getY() + this.boxHeight;

        return !(insideWidth && insideHeight);
    }

    @Override
    public List<Wall> getMapWalls() {
        return this.walls;
    }

    @Override
    public List<Collectible> getMapCollectibles() {
        return this.collectibles;
    }

    @Override
    public List<Employee> getMapEmployees() {
        return this.employees;
    }


    @Override
    public Point getGatePosition() {
        return this.gatePosition;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getBoxHeight() {
        return boxHeight;
    }

    @Override
    public int getBoxWidth() {
        return boxWidth;
    }

    @Override
    public Point getBoxPosition() {
        return boxPosition;
    }
}
