package pt.up.fe.ldts.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static pt.up.fe.ldts.model.Jorge.jorge;

public class JorgeTest {

    @BeforeEach
    public void setup(){
        jorge.changePos(4,5);
    }

    @Test
    public void testCoords() {

        Assertions.assertEquals(4, jorge.getX());
        Assertions.assertEquals(5, jorge.getY());
    }



}
