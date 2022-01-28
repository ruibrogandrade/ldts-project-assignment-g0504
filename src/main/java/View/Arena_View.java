package View;

import Controller.Arena_Controller;
import Model.ArenaModelFactory;
import Model.Arena_Model;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Arena_View extends AbstractView {
    private View menu;
    private TextGraphics tg;
    private Arena_Controller controller;
    private View hitmarker;

    public Arena_View(Screen screen, int lvl, View menu){
        super(screen);

        ArenaModelFactory factory = new ArenaModelFactory(70, 35);

        Arena_Model model;

        switch (lvl) {
            case 1:
                model = factory.createLvl1Arena();
                break;
            case 2:
                model = factory.createLvl2Arena();
                break;
            case 3:
                model = factory.createLvl3Arena();
                break;
            case 4:
                model = factory.createLvl4Arena();
                break;
            case 5:
                model = factory.createLvl5Arena();
                break;
            default:
                throw new IllegalArgumentException("Invalid level");
        }

        this.menu = menu;
        this.hitmarker = new Hitmarker_View(model.getHitmarker(), screen);
        this.controller = new Arena_Controller(model);

        this.tg = screen.newTextGraphics();
    }

    public void drawChildren() throws IOException {
        for(View view : getAllViews()) {
            view.draw();
        }
    }

    private List<View> getAllViews() {
        List<View> allViews = new LinkedList<>();

        allViews.add(new Player_View(controller.getModel().getPlayer(), screen));
        allViews.addAll(controller.getModel().getBorders().stream().map(border -> new Border_View(border, screen)).collect(Collectors.toList()));
        allViews.addAll(controller.getModel().getShips().stream().map(ship -> new Ship_View(ship, screen)).collect(Collectors.toList()));
        allViews.addAll(controller.getModel().getIsles().stream().map(isle -> new Isle_View(isle, screen)).collect(Collectors.toList()));
        allViews.add(this.hitmarker);

        return allViews;
    }

    private void drawBackground() {
        screen.clear();
        tg.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        tg.fill(' ');
    }


    public void draw() {
        try {
            while(true) {
                drawBackground();
                drawChildren();
                screen.refresh();

                KeyStroke key = screen.readInput();
                controller.processKey(key);

                if (key.getKeyType() == KeyType.Escape) {
                    screen.close();
                    break;
                }
                else if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'b') {
                    screen.close();
                    menu.draw();
                    break;
                }
                else if (key.getKeyType() == KeyType.Enter) {
                    controller.shipHits();
                    controller.moveShips();
                    controller.verifyShipCollisions();
                }
                else if (key.getKeyType() == KeyType.EOF)
                    break;
                if (controller.getModel().getShips().size() == 0) {
                    screen.close();
                    System.out.println("You won!");
                    break;
                }
                if (controller.anyShipHitsIsle()) {
                    screen.close();
                    System.out.println("You lost, a ship reached the island");
                    break;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
