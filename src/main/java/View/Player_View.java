package View;

import Model.Isle_Model;
import Model.Player_Model;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Player_View extends AbstractView{
    private Player_Model player;

    public Player_View(Player_Model player, Screen screen){
        super(screen);
        this.player = player;
    }

    public void draw() {
        TextGraphics tg = screen.newTextGraphics();
        tg.enableModifiers(SGR.BOLD);
        tg.setBackgroundColor(TextColor.ANSI.BLUE_BRIGHT);
        tg.putString(new TerminalPosition(player.getX(), player.getY()), " ");
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
    }

}
