import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsleTest {

    @Test
    public void find_corners() {
        List<Isle> testIsles = new ArrayList<>();
        testIsles.add(new Isle(1,32));
        testIsles.add(new Isle(1,33));
        testIsles.add(new Isle(2,32));
        testIsles.add(new Isle(2,33));

        Isle isle = new Isle();
        List<Integer> testResult = isle.find_corners(testIsles);
        List<Integer> correctResult = Arrays.asList(1,33,2,32);

        Assertions.assertEquals(correctResult, testResult);
    }

}
