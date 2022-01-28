package View;

import Model.Player_Model;
import Model.Ship_Model;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.util.Objects;

public class Ship_View extends AbstractView {
    private Ship_Model ship;

    public Ship_View(Ship_Model ship, Screen screen){
        super(screen);
        this.ship = ship;
    }

    public void draw() {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.setForegroundColor(TextColor.ANSI.BLACK_BRIGHT);
        if (Objects.equals(ship.getDirection(), "v"))
            tg.drawRectangle(new TerminalPosition(ship.getX(), ship.getY()), new TerminalSize(1, ship.getSize()), Symbols.SOLID_SQUARE);
        else if (Objects.equals(ship.getDirection(), "h"))
            tg.drawRectangle(new TerminalPosition(ship.getX(), ship.getY()), new TerminalSize(ship.getSize(), 1), Symbols.SOLID_SQUARE);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
    }
}
