package Model;

import java.util.ArrayList;
import java.util.List;

public class Player_Model {
    private int x;
    private int y;

    public Player_Model() {}

    public Player_Model(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
