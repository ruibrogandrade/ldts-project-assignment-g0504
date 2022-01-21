import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static int x;
    private static int y;

    public Player() {}

    public Player(int x, int y) {
        Player.x = x;
        Player.y = y;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public void setX(int x) {
        Player.x = x;
    }

    public void setY(int y) {
        Player.y = y;
    }

    public void draw(TextGraphics screen, List<Integer> corners) {
        screen.enableModifiers(SGR.BOLD);
        List<Integer> center = find_center(corners);
        screen.setBackgroundColor(TextColor.ANSI.BLUE_BRIGHT);
        screen.putString(new TerminalPosition(center.get(0), center.get(1)), " ");
        screen.setBackgroundColor(TextColor.ANSI.DEFAULT);
    }

    public List<Integer> find_center(List<Integer> corners) {
        float x = (corners.get(0) + (((float)corners.get(2) - corners.get(0)) / 2));
        float y = (corners.get(3) + (((float)corners.get(1) - corners.get(3)) / 2));
        int intx = Math.round(x);
        int inty = Math.round(y);
        int finalx = intx;
        int finaly = inty;
        double check = Math.random();
        List<Integer> result = new ArrayList<>();
        /*
        if (intx - x != 0) {
            if (check >= 0.5) finalx = intx;
            else finalx = intx - 1;
        }
        if (inty - y != 0) {
            if (check >= 0.5) finaly = inty;
            else finaly = inty - 1;
        }
         */
        result.add(finalx);
        result.add(finaly);
        Player.x = finalx;
        Player.y = finaly;
        return result;
    }
}
