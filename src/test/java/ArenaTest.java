import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class ArenaTest {
    @Test
    public void testConstructor() {
        Arena arena = new Arena(10, 10,1);

        assertEquals(10, arena.getHeight());
        assertEquals(10, arena.getWidth());
    }
}
