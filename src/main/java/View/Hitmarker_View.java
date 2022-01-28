package View;

import Model.Hitmarker_Model;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class Hitmarker_View extends AbstractView{
    private Hitmarker_Model hitmarker;

    public Hitmarker_View(Hitmarker_Model model, Screen screen){
        super(screen);
        this.hitmarker = model;
    }

    public void draw() throws IOException{
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        tg.setForegroundColor(TextColor.ANSI.BLACK);
        tg.putString(hitmarker.getX(), hitmarker.getY(), ("X"), SGR.BLINK);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
    }
}