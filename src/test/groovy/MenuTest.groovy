import spock.lang.Specification

import java.awt.Robot;

class MenuTest extends Specification {
    def 'test menu change(Play+Enter)'() {
        setup:
        Robot robot = new Robot();
        def calls = 0
        def filter = new Menu();
        filter.run();
        robot.keyPress(KeyEvent.ENTER);
        robot.keyRelease(KeyEvent.ENTER);
        when:
        filter.drawLevelMenu();
        then:
        calls==1
    }
}