package View;

import Model.Border_Model;
import Model.Isle_Model;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;

public class Isle_View extends AbstractView {
    private Isle_Model isle;

    public Isle_View(Isle_Model isle, Screen screen){
        super(screen);
        this.isle = isle;
    }

    public void draw() {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.ANSI.RED_BRIGHT);
        tg.putString(new TerminalPosition(isle.getX(), isle.getY()), " ");
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
    }

}
