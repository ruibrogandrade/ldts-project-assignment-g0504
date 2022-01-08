import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(70, 35);
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

    public void drawMenu(int pos) throws IOException{
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

    public void drawCustomGame() throws IOException {
        screen.clear();
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.ANSI.BLUE);
        tg.fill(' ');
        tg.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
        tg.putString(20, 2, "Custom Game");
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        screen.refresh();
    }

    public void drawLevelMenu(int pos) throws IOException, InterruptedException {
        screen.clear();
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
        tg.putString(22, 2, "Levels");
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(2, 8, "Level 1");
        tg.putString(2, 11, "Level 2");
        tg.putString(2, 14, "Level 3");
        tg.putString(2, 17, "Level 4");
        tg.putString(2, 20, "Level 5");
        tg.putString(20, 14, "Custom Game");
        tg.putString(20, 17, "Commands:");
        tg.putString(20, 19, "Type the level number you want to play");
        tg.putString(20, 20, "When that level is lit up, click Enter");
        tg.putString(20, 22, "If you want to create your own game, press C");
        if (pos == 1) {
            tg.putString(2, 8, "Level 1", SGR.BOLD);
        }
        else if (pos == 2) {
            tg.putString(2, 11, "Level 2", SGR.BOLD);
        }
        else if (pos == 3) {
            tg.putString(2, 14, "Level 3", SGR.BOLD);
        }
        else if (pos == 4) {
            tg.putString(2, 17, "Level 4", SGR.BOLD);
        }
        else if (pos == 5) {
            tg.putString(2, 20, "Level 5", SGR.BOLD);
        }
        else if (pos == 6) {
            tg.putString(20,14, "Custom Game", SGR.BOLD);
        }
        screen.refresh();
        chooseLevel(pos);
    }

    public void drawLevels(int pos) throws IOException, InterruptedException {
        screen.clear();
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.ANSI.BLUE);
        tg.fill(' ');
        tg.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
        if (pos == 1) {
            tg.putString(22, 2, "Level 1");
        }
        else if (pos == 2) {
            tg.putString(22, 2, "Level 2");
        }
        else if (pos == 3) {
            tg.putString(22, 2, "Level 3");
        }
        else if (pos == 4) {
            tg.putString(22, 2, "Level 4");
        }
        else if (pos == 5) {
            tg.putString(22, 2, "Level 5");
        }
        else if (pos == 6) {
            drawCustomGame();
        }
        screen.refresh();
        insideLevel();

        //supostamente isto ja seria uma classe nova com os levels e isso tudo
    }

    public void insideLevel() throws IOException, InterruptedException {
        boolean keepRunning = true;
        while (keepRunning) {
            KeyStroke key = screen.readInput();

            switch (key.getKeyType()) {
                case Escape:
                    keepRunning = false;
                    screen.close();;
                    System.out.println("Ended Game");
                    break;
                case EOF:
                    keepRunning = false;
                    break;
                case Character:
                    if (key.getCharacter() == 'm') {
                        drawLevelMenu(1);
                        break;
                    }
            }
        }
    }

    public void chooseLevel(int pos) throws IOException, InterruptedException {
        boolean keepRunning = true;
        while (keepRunning) {
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
                case Character:
                    if (key.getCharacter() == ('b')) {
                        keepRunning = false;
                        break;
                    }
                    else if (key.getCharacter() == ('c')) {
                        pos = 6;
                        drawLevelMenu(6);
                        break;
                    }
                    else if (key.getCharacter() == '1') {
                        pos = 1;
                        drawLevelMenu(1);
                        break;
                    }
                    else if (key.getCharacter() == '2') {
                        pos = 2;
                        drawLevelMenu(2);
                        break;
                    }
                    else if (key.getCharacter() == '3') {
                        pos = 3;
                        drawLevelMenu(3);
                        break;
                    }
                    else if (key.getCharacter() == '4') {
                        pos = 4;
                        drawLevelMenu(4);
                        break;
                    }
                    else if (key.getCharacter() == '5') {
                        pos = 5;
                        drawLevelMenu(5);
                        break;
                    }
                case Enter:
                    keepRunning = false;
                    drawLevels(pos);
                    break;
            }
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
            screen.refresh();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            drawMenu(1);
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
                            drawMenu(2);
                            pos = 2;
                            break;
                        }
                        else if (pos == 2) {
                            drawMenu(3);
                            pos = 3;
                            break;
                        }
                    case ArrowUp:
                        if (pos == 2) {
                            drawMenu(1);
                            pos = 1;
                            break;
                        }
                        else if (pos == 3) {
                            drawMenu(2);
                            pos = 2;
                            break;
                        }
                    case Enter:
                        if (pos == 1) {
                            drawLevelMenu(1);
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
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Screen screen;
}