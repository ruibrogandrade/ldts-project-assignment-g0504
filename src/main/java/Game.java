import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.IOException;

public class Game {
    public Game() {
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

    public void draw(int pos) throws IOException{
        screen.clear();
        TextGraphics tg = screen.newTextGraphics();
        switch (pos) {
            case 1 -> {
                tg.putString(20, 7, "1)Play", SGR.BLINK);
                tg.putString(20, 12, "2)Instructions");
                tg.putString(20, 17, "3)Exit");
            }
            case 2 -> {
                tg.putString(20, 7, "1)Play");
                tg.putString(20, 12, "2)Instructions", SGR.BLINK);
                tg.putString(20, 17, "3)Exit");
            }
            case 3 -> {
                tg.putString(20, 7, "1)Play");
                tg.putString(20, 12, "2)Instructions");
                tg.putString(20, 17, "3)Exit", SGR.BLINK);
            }
            default -> {
            }
        }
        screen.refresh();
    }

    public void readFile() throws IOException {
        try {
            screen.clear();
            TextGraphics tg = screen.newTextGraphics();
            tg.putString(20, 5, "Instructions:");

            int row = 10;

            File myObj = new File("instructions.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                tg.putString(5, row, data);
                row++;
            }
            screen.refresh();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
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
                            readFile();
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