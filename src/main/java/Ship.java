import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ship {
    public Ship(int size, String direction, int x, int y) {
        this.size = size;
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public boolean shipFits(List<Integer> ship) {
        for (int i = 0; i < ship.size(); i += 2) {
            if (ship.get(i) > Arena.getWidth() - 1 || ship.get(i+1) > Arena.getHeight() - 1) {
                return false;
            }
        }
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void draw(TextGraphics tg) {
        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.setForegroundColor(TextColor.ANSI.BLACK_BRIGHT);
        if (Objects.equals(direction, "v"))
            tg.drawRectangle(new TerminalPosition(x, y), new TerminalSize(1, size), Symbols.SOLID_SQUARE);
        else if (Objects.equals(direction, "h"))
            tg.drawRectangle(new TerminalPosition(x, y), new TerminalSize(size, 1), Symbols.SOLID_SQUARE);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
    }

    private int size;
    private String direction;
    private int x;
    private int y;
}
