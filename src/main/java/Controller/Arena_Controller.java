package Controller;

import Model.*;
import View.Border_View;
import View.Isle_View;
import View.Ship_View;
import View.View;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Arena_Controller extends Controller<Arena_Model>{

    public Arena_Controller(Arena_Model model) {
        super(model);
    }

    public void shipMoveUp(Ship_Model ship) {
        ship.setY(ship.getY() - 1);
        ship.setDirection("v");
    }

    public void shipMoveDown(Ship_Model ship) {
        ship.setY(ship.getY() + 1);
        ship.setDirection("v");
    }

    public void shipMoveLeft(Ship_Model ship) {
        ship.setX(ship.getX() - 1);
        ship.setDirection("h");
    }

    public void shipMoveRight(Ship_Model ship) {
        ship.setX(ship.getX() + 1);
        ship.setDirection("h");
    }

    public boolean shipHits(Ship_Model ship, Hitmarker_Model hitmarker) {
        for (int i = 0; i < ship.getCoord().size(); i += 2) {
            if (ship.getCoord().get(i) == hitmarker.getX() && ship.getCoord().get(i+1) == hitmarker.getY()) {
                return true;
            }
        }
        return false;
    }

    public void shipHits() {
        for (Ship_Model ship : new LinkedList<>(model.getShips())) {
            if (shipHits(ship, model.getHitmarker()))  {
                if (ship.getSize() <= 1) {
                    model.getShips().remove(ship);
                }
                else {
                    ship.setSize(ship.getSize() - 1);
                }
            }
        }
    }

    public boolean shipHitsIsle(Ship_Model ship) {
        for (int i = 0; i < ship.getCoord().size(); i += 2) {
            for (Isle_Model isle : model.getIsles()) {
                if (ship.getCoord().get(i) == isle.getX() && ship.getCoord().get(i+1) == isle.getY())
                    return true;
            }
        }
        return false;
    }

    public boolean anyShipHitsIsle() {
        return model.getShips().stream().anyMatch(ship -> shipHitsIsle(ship));
    }

    public ArrayList<Ship_Model> verifyShipCollisions() {
        ArrayList<Ship_Model> extra = new ArrayList<>();
        for (int i = 0; i < model.getShips().size(); i++) {
            for (int j = i+1; j < model.getShips().size(); j++) {
                for (int k = 0; k < model.getShips().get(i).getCoord().size(); k += 2) {
                    for (int l = 0; l < model.getShips().get(j).getCoord().size(); l += 2) {
                        if (Objects.equals(model.getShips().get(i).getCoord().get(k), model.getShips().get(j).getCoord().get(l)) && Objects.equals(model.getShips().get(i).getCoord().get(k + 1), model.getShips().get(j).getCoord().get(l + 1))) {
                            extra.add(model.getShips().get(i));
                            extra.add(model.getShips().get(j));
                        }
                    }
                }
            }
        }
        return extra;
    }


    public void moveShips() {
        for (Ship_Model ship : model.getShips()) {
            if (model.getPlayer().getX() < ship.getX()) {
                shipMoveLeft(ship);
            }
            else if (model.getPlayer().getX() > ship.getX()) {
                shipMoveRight(ship);
            }
            else if (model.getPlayer().getY() < ship.getY()) {
                shipMoveUp(ship);
            }
            else if (model.getPlayer().getY() > ship.getY()) {
                shipMoveDown(ship);
            }
        }
    }

    private void removeShips() {
        ArrayList<Ship_Model> ships = verifyShipCollisions();
        if (ships.size() > 0) {
            for (Ship_Model ship : ships) {
                model.getShips().remove(ship);
            }
        }
    }

    public void processKey(KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp    -> model.getHitmarker().moveUp();
            case ArrowDown  -> model.getHitmarker().moveDown();
            case ArrowLeft  -> model.getHitmarker().moveLeft();
            case ArrowRight -> model.getHitmarker().moveRight();
        }    }
}
