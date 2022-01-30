import Model.Arena_Model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArenaSizeTest {
    @Test
    public void ArenaSize(){
        Arena_Model arena = new Arena_Model(70,35);
        assertEquals(70, arena.getWidth());
        assertEquals(35,arena.getHeight());
    }
}