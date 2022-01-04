package pt.up.fe.ldts.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.view.sprites.Sprite;

public class CollectibleTest {

    @Test
    public void testCoords(){
        Collectible collectible = new Collectible(5, 4) {
            @Override
            protected Sprite loadSprite() {
                return null;
            }

            @Override
            public void notifyCollected() {}
        };

        Assertions.assertEquals(5, collectible.getX());
        Assertions.assertEquals(4, collectible.getY());
    }
}
