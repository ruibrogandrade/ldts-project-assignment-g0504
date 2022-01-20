import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
    public Game(Screen screen) {
        this.screen = screen;
        arena = Menu.arena;
    }

    public void draw() throws IOException {
        screen.clear();
        arena.draw(screen);
        screen.refresh();
    }

    private void processKey(KeyStroke key){
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp    -> arena.hitmarkerMoveUp();
            case ArrowDown  -> arena.hitmarkerMoveDown();
            case ArrowLeft  -> arena.hitmarkerMoveLeft();
            case ArrowRight -> arena.hitmarkerMoveRight();
        }
    }

    private void moveShips() {
        for (Ship ship : arena.getShips()) {
            if (Player.getX() < ship.getX()) {
                arena.shipMoveLeft(ship);
            }
            else if (Player.getX() > ship.getX()) {
                arena.shipMoveRight(ship);
            }
            else if (Player.getY() < ship.getY()) {
                arena.shipMoveUp(ship);
            }
            else if (Player.getY() > ship.getY()) {
                arena.shipMoveDown(ship);
            }
        }
    }

    private void shipHits() {
        ArrayList<Ship> extra = new ArrayList<>();
        for (Ship ship : arena.getShips()) {
            if (arena.shipHits(ship))  {
                if (ship.getSize() <= 1)
                    extra.add(ship);
                else ship.setSize(ship.getSize()-1);
            }
        }
        for (Ship ship : extra) {
            arena.getShips().remove(ship);
        }
    }

    public void run() {
        try {
            while(true) {
                draw();
                KeyStroke key = screen.readInput();
                processKey(key);

                if (key.getKeyType() == KeyType.Escape) {
                    screen.close();
                    break;
                }
                if (arena.getShips().size() == 0) {
                    screen.close();
                    System.out.println("You won!");
                    break;
                }
                else if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'b') {
                    Menu menu = new Menu();
                    screen.close();
                    menu.run();
                    break;
                }
                else if (key.getKeyType() == KeyType.Enter) {
                    shipHits();
                    moveShips();
                }
                if (key.getKeyType() == KeyType.EOF)
                    break;
            }
        } catch (IOException | FontFormatException e){
            e.printStackTrace();
        }

    }

    private Screen screen;
    private Arena arena;
}
