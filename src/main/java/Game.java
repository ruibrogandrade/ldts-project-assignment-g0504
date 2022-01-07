import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    public Game() throws IOException {
        try {
            TerminalSize terminalSize = new TerminalSize(50, 25);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw(int pos) throws IOException{
        screen.clear();
        TextGraphics tg = screen.newTextGraphics();
        switch (pos) {
            case 1:
                tg.putString(20, 7, "1)Play", SGR.BLINK);
                tg.putString(20,12,"2)Rules");
                tg.putString(20,17,"3)Exit");
                break;
            case 2:
                tg.putString(20, 7, "1)Play");
                tg.putString(20,12,"2)Rules", SGR.BLINK);
                tg.putString(20,17,"3)Exit");
                break;
            case 3:
                tg.putString(20, 7, "1)Play");
                tg.putString(20,12,"2)Rules");
                tg.putString(20,17,"3)Exit", SGR.BLINK);
                break;
            default:
                break;
        }
        screen.refresh();
    }

    public void run() {
        try {
            draw(1);
            boolean keepRunning = true;
            int pos = 1;
            while(keepRunning) {
                KeyStroke key = screen.readInput();

                switch (key.getKeyType()) {
                    case Escape:
                        keepRunning = false;
                        screen.close();
                        System.out.println("Ended Game");
                        break;
                    case EOF:
                        keepRunning = false;
                        break;
                    case ArrowDown:
                        if (pos == 1) {
                            draw(2);
                            pos = 2;
                            break;
                        }
                        else if (pos == 2) {
                            draw(3);
                            pos = 3;
                            break;
                        }
                    case ArrowUp:
                        if (pos == 2) {
                            draw(1);
                            pos = 1;
                            break;
                        }
                        else if (pos == 3) {
                            draw(2);
                            pos = 2;
                            break;
                        }
                    case Enter:
                        if (pos == 1) {

                        }
                        else if (pos == 2) {

                        }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Screen screen;
}