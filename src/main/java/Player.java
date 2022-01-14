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
        Float x = Float.valueOf((corners.get(3) - corners.get(0)) / 2);
        Float y = Float.valueOf((corners.get(1) - corners.get(1)) / 2);
        if (x == )
        screen.putString(new TerminalPosition(getX(), getY()), "#");
    }
}
