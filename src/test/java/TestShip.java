import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestShip {

    @Test
    public void ship_getters(){
        Ship ship = new Ship(2,"h", 2, 30);
        assertEquals(2, ship.getX());
        assertEquals(30, ship.getY());
        assertEquals("h", ship.getDirection());
        assertEquals(2, ship.getSize());
    }
    //TODO erro com as listas
    /*
    @Test
    public void test_shipFits(){
        Arena arena = new Arena(40,40);

        List<Integer> testShips = new ArrayList<>();
        testShips.add(10);

        Ship ship = new Ship();
        assertEquals(true, ship.shipFits(testShips));
    }
     */
}
