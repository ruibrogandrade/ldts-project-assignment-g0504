package Model;

import View.View;
import com.googlecode.lanterna.screen.Screen;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arena_Model{
    private int width;
    private int height;
    private Player_Model player;
    private List<Border_Model> borders;
    private List<Isle_Model> isles;
    private List<Ship_Model> ships;
    private Hitmarker_Model hitmarker;

    public Arena_Model(int width, int height, List<Border_Model> borders, List<Isle_Model> isles, List<Ship_Model> ships) {
        this.width = width;
        this.height = height;

        this.borders = borders;
        this.isles = isles;
        this.ships = ships;

        int[] islesCenter = findIslesCenter();
        this.player = new Player_Model(islesCenter[0], islesCenter[1]);
        this.hitmarker = new Hitmarker_Model(width / 2, height / 2);
    }

    public Arena_Model(int width, int height){
        this.width = width;
        this.height = height;
    }


    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public List<Border_Model> getBorders() {
        return borders;
    }

    public List<Isle_Model> getIsles() {
        return isles;
    }

    public List<Ship_Model> getShips() {
        return ships;
    }

    public Player_Model getPlayer() {
        return player;
    }

    public Hitmarker_Model getHitmarker() {
        return hitmarker;
    }

    private int[] findCorners() {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        //Bottom Left Corner
        for(int i = 0; i < isles.size(); i++) {
            if (i == 0) {
                x1 = isles.get(i).getX();
                y1 = isles.get(i).getY();
            }
            if (isles.get(i).getX() < x1) x1 = isles.get(i).getX();
            if (isles.get(i).getY() > y1) y1 = isles.get(i).getY();
        }
        //Top Right Corner
        for(int i = 0; i < isles.size(); i++) {
            if (i == 0) {
                x2 = isles.get(i).getX();
                y2 = isles.get(i).getY();
            }
            if (isles.get(i).getX() > x2) x2 = isles.get(i).getX();
            if (isles.get(i).getY() < y2) y2 = isles.get(i).getY();
        }
        return new int[]{x1,y1,x2,y2};
    }

    private int[] findIslesCenter() {
        int[] corners = findCorners();
        float x = (corners[0] + (((float)corners[2] - corners[0]) / 2));
        float y = (corners[3] + (((float)corners[1] - corners[3]) / 2));
        return new int[]{Math.round(x), Math.round(y)};
    }

}
