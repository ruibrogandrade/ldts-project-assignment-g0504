import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HitmarkerTest {

    @Test
    public void hitmarker_getters() {
        Hitmarker hitmarker = new Hitmarker(2,3);
        assertEquals(2, hitmarker.getX());
        assertEquals(3, hitmarker.getY());
    }

}
