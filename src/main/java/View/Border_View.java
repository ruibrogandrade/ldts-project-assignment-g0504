package View;

import Model.Arena_Model;
import Model.Border_Model;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;

public class Border_View extends AbstractView {
    private Border_Model border;

    public Border_View(Border_Model border, Screen screen){
        super(screen);
        this.border = border;
    }

    public void draw() {
        TextGraphics tg = screen.newTextGraphics();
        tg.enableModifiers(SGR.BOLD);
        tg.putString(new TerminalPosition(border.getX(), border.getY()), "#");
    }

}
