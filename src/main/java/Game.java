import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {


    public void Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(50, 25);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            Screen screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);

            TextGraphics tg = screen.newTextGraphics();

            screen.startScreen();
            screen.doResizeIfNecessary();
            screen.clear();
            tg.putString(20, 7, "1)Play");
            tg.putString(20,12,"2)Rules");
            tg.putString(20,17,"3)Exit");
            screen.refresh();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}