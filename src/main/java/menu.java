import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class menu {

    public static void main(String[] args) {
       menu();
    }
    public static void menu() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            Screen screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);

            TextGraphics tg = screen.newTextGraphics();

            screen.startScreen();
            screen.doResizeIfNecessary();
            screen.clear();
            tg.putString(20, 10, "Play");
            screen.refresh();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}