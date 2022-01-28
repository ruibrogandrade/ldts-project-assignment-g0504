package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Ship_Model {
    private int x;
    private int y;
    private int size;
    private String direction;

    public Ship_Model(int size, String direction, int x, int y) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.direction = direction;
    }

    public ArrayList<Integer> getCoord() {
        ArrayList<Integer> shipCoord = new ArrayList<>();

        if (Objects.equals(getDirection(), "v")) {
            for (int i = 0; i < getSize(); i++) {
                shipCoord.add(getX());
                shipCoord.add(getY()+i);
            }
        }
        else if (Objects.equals(getDirection(), "h")) {
            for (int i = 0; i < getSize(); i++) {
                shipCoord.add(getX()+i);
                shipCoord.add(getY());
            }
        }

        return shipCoord;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public String getDirection() {
        return direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
