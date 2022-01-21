import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BorderTest {

    @Test
    public void border_getters() {
        Border border = new Border(2,3);
        assertEquals(2, border.getX());
        assertEquals(3,border.getY());
    }


}
