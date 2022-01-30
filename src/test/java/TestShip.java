import Model.Ship_Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestShip {

    @Test
    public void ship_getters() {
        Ship_Model ship = new Ship_Model(2, "h", 2, 30);
        assertEquals(2, ship.getX());
        assertEquals(30, ship.getY());
        assertEquals("h", ship.getDirection());
        assertEquals(2, ship.getSize());
    }
    //TODO erro com as listas
}