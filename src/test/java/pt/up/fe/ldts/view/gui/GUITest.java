package pt.up.fe.ldts.view.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GUITest {

    @Test
    public void testFontLoading() {
        Assertions.assertDoesNotThrow(() -> {
            new LanternaGUI(1, 1);
        });
    }
}
