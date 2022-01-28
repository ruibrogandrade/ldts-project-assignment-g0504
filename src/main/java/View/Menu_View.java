package View;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Menu_View extends AbstractView {

    private Levels_View level;

    public Menu_View(Screen screen)throws IOException {
        super(screen);

        this.screen.setCursorPosition(null);   // we don't need a cursor
        this.screen.startScreen();             // screens must be started
        this.screen.doResizeIfNecessary();     // resize screen if necessary

        this.level = new Levels_View(screen, this);
    }

    private void blinkPosition(int pos) throws IOException {
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


    public void draw() {
        try {
            blinkPosition(1);
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
                            blinkPosition(2);
                            pos = 2;
                            break;
                        }
                        else if (pos == 2) {
                            blinkPosition(3);
                            pos = 3;
                            break;
                        }
                        break;
                    case ArrowUp:
                        if (pos == 2) {
                            blinkPosition(1);
                            pos = 1;
                            break;
                        }
                        else if (pos == 3) {
                            blinkPosition(2);
                            pos = 2;
                            break;
                        }
                        break;
                    case Enter:
                        if (pos == 1) {
                            level.drawLevelMenu(pos);
                            keepRunning = false;
                            break;
                        }
                        else if (pos == 2) {
                            readFile();
                            break;
                        }
                        screen.close();
                        break;
                    default:
                        break;
                }
            }
        }
        catch (IOException | InterruptedException | FontFormatException e) {
            e.printStackTrace();
        }
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
            tg.putString(2,24, "Press ArrowUp to return to Menu");
            tg.putString(14,16, String.valueOf(Symbols.CLUB));
            screen.refresh();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
