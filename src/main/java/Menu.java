import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.EscapeSequenceCharacterPattern;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Menu {
    /*
    public Menu() throws IOException {
        try {
            TerminalSize terminalSize = new TerminalSize(50, 25);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            Screen screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        draw();
    }
    */

    public void draw(TextGraphics tg, int pos) throws IOException{
        tg.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        screen.clear();
        switch (pos) {
            case 1:
                tg.putString(20, 7, "1)Play");
                tg.putString(20,12,"2)Rules", SGR.BLINK);
                tg.putString(20,17,"3)Exit");
            case 2:
                tg.putString(20, 7, "1)Play");
                tg.putString(20,12,"2)Rules");
                tg.putString(20,17,"3)Exit", SGR.BLINK);
            default:
                break;

        }
        screen.refresh();
    }

    public void run() {
        try {
            boolean keepRunning = true;
            while(keepRunning) {
                int pos = 1;
                //draw();
                KeyStroke key = screen.readInput();

                switch (key.getKeyType()) {
                    case Escape:
                        keepRunning = false;
                        screen.close();
                    case EOF:
                        keepRunning = false;
                        break;
                    case ArrowDown:
                        if (pos == 1) {
                            screen.clear();
                            TextGraphics tg = screen.newTextGraphics();
                            tg.putString(20, 7, "1)Play");
                            tg.putString(20,12,"2)Rules",SGR.BLINK);
                            tg.putString(20,17,"3)Exit");
                            pos = 2;
                        }
                        else if (pos == 2) {
                            screen.clear();
                            TextGraphics tg = screen.newTextGraphics();
                            tg.putString(20, 7, "1)Play");
                            tg.putString(20,12,"2)Rules");
                            tg.putString(20,17,"3)Exit", SGR.BLINK);
                            pos = 2;
                        }

                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key) {

    }

    private Screen screen;
}
