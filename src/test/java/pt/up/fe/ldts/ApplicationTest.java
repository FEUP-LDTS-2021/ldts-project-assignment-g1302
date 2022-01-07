package pt.up.fe.ldts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.model.Cerveja;
import pt.up.fe.ldts.model.Collectible;
import pt.up.fe.ldts.model.Wall;
import pt.up.fe.ldts.model.Point;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationTest {
    @Test
    public void createCollectiblesCorrectly() throws IOException, URISyntaxException, FontFormatException {
        var app = Mockito.mock(Application.class);
        Mockito.doAnswer(invocation -> {
            List<Wall> walls = new ArrayList<>();
            for (int i = 0; i <= 3; i++){
                walls.add(new Wall(i, 1));
                walls.add(new Wall(i, 4));
            }
            for (int i = 0; i <= 4; i++){
                walls.add(new Wall(0, i));
                walls.add(new Wall(3, i));
            }
            return walls;
        }).when(app).getMapWalls(Mockito.any(), Mockito.any());

        List<Point> wallPos = new ArrayList<>();
        List<Point> collectiblePos = new ArrayList<>();
        for(Wall w : app.getMapWalls(4, 4)){
            wallPos.add(w.getPosition());
        }
        for(Collectible c : app.getMapCollectibles(4, 4)){
            collectiblePos.add(c.getPosition());
        }

        for (Point p: collectiblePos){
            Assertions.assertFalse(wallPos.contains(p));
        }

        Assertions.assertTrue(app.getMapCollectibles(4, 4).contains(new Cerveja(1, 3)));

        Assertions.assertEquals(4, collectiblePos.size());

    }
}