import static org.junit.jupiter.api.Assertions.assertEquals;

import Model.Border_Model;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BorderTest {

    @Test
    public void border_getters() {
        Border_Model border = new Border_Model(2,3);
        assertEquals(2, border.getX());
        assertEquals(3,border.getY());
    }

}