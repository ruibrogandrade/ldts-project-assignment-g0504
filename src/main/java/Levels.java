import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.awt.*;
import java.io.IOException;

public class Levels {
    public Levels(Screen screen) {
        this.screen = screen;
    }

    public void drawLevelMenu(int pos) throws IOException, InterruptedException, FontFormatException {
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
        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString(20, 17, "Commands:");
        tg.putString(20, 19, "Type the level number you want to play");
        tg.putString(20, 20, "When that level is lit up, click Enter");
        tg.putString(20, 22, "If you want to create your own game, press C");
        tg.putString(20, 24, "To return to Main Menu, press B");
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
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
        chooseLevel();
    }

    public void chooseLevel() throws IOException, InterruptedException, FontFormatException {
        boolean keepRunning = true;
        while (keepRunning) {
            KeyStroke key = screen.readInput();

            int pos;
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
                        Menu menu = new Menu();
                        screen.close();
                        menu.run();
                        break;
                    }
                    else if (key.getCharacter() == ('c')) {
                        pos = 6;
                        drawLevelMenu(6);
                        break;
                    }
                    else if (key.getCharacter() == '1') {
                        pos = 1;
                        lvl = 1;
                        drawLevelMenu(1);
                        break;
                    }
                    else if (key.getCharacter() == '2') {
                        pos = 2;
                        lvl = 2;
                        drawLevelMenu(2);
                        break;
                    }
                    else if (key.getCharacter() == '3') {
                        pos = 3;
                        lvl = 3;
                        drawLevelMenu(3);
                        break;
                    }
                    else if (key.getCharacter() == '4') {
                        pos = 4;
                        lvl = 4;
                        drawLevelMenu(4);
                        break;
                    }
                    else if (key.getCharacter() == '5') {
                        pos = 5;
                        lvl = 5;
                        drawLevelMenu(5);
                        break;
                    }
                case Enter:
                    keepRunning = false;
                    arena = new Arena(70,35,lvl);
                    Game game = new Game(screen);
                    game.run();
                    break;
            }
        }
    }
    public static int lvl;
    public static Arena arena;
    private final Screen screen;
}
