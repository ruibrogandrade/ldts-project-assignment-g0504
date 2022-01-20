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

public class Menu {
    public Menu() throws IOException, FontFormatException {
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File("resources\\square.ttf");
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        TerminalSize tsize = new TerminalSize(70,35);
        DefaultTerminalFactory factory = new DefaultTerminalFactory().setInitialTerminalSize(tsize);

        Font loadedFont = font.deriveFont(Font.PLAIN, 10);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        factory.setTerminalEmulatorFontConfiguration(fontConfig);
        factory.setForceAWTOverSwing(true);

        Terminal terminal = factory.createTerminal();
        ((AWTTerminalFrame)terminal).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        arena = new Arena(70,35);
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
            tg.putString(2,24, "Press ArrowUp to return to Menu");
            tg.putString(14,16, String.valueOf(Symbols.CLUB));
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
                            Levels levels = new Levels(screen);
                            levels.drawLevelMenu(pos);
                            keepRunning = false;
                            break;
                        }
                        else if (pos == 2) {
                            readFile();
                            break;
                        }
                        else {
                            screen.close();
                            break;
                        }
                }
            }
        }
        catch (IOException | InterruptedException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    private Screen screen;
    public static Arena arena;
}