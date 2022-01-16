import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerTest {

    @Test
    public void find_center() {
        List<Isle> testIsles = new ArrayList<>();
        testIsles.add(new Isle(1,32));
        testIsles.add(new Isle(1,33));
        testIsles.add(new Isle(2,32));
        testIsles.add(new Isle(2,33));

        Player player = new Player();
        List<Integer> testResult = player.find_center(testIsles);
        List<Integer> correctResult = Arrays.asList(10,20);

        Assertions.assertEquals(correctResult, testResult);
    }

}
