import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerTest {

    @Test
    public void find_center() {
        List<Integer> testCorners = new ArrayList<>();
        testCorners.add(10);
        testCorners.add(12);
        testCorners.add(12);
        testCorners.add(10);

        Player player = new Player();
        List<Integer> testResult = player.find_center(testCorners);
        List<Integer> correctResult = Arrays.asList(11,11);

        Assertions.assertEquals(correctResult, testResult);
    }

}
