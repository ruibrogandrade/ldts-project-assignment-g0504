import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Player {
    private int x;
    private int y;

    public Player() {}

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(TextGraphics screen, List<Integer> corners) {
        screen.enableModifiers(SGR.BOLD);

        screen.putString(new TerminalPosition(getX(), getY()), "#");
    }
}
