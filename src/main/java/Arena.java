import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Arena {

    public Arena(int width, int height) {
        this.height = height;
        this.width = width;
        borders = createBorders();
        isles = createIsle();
        ships = createShips();
        height1 = height;
        width1 = width;
    }

    //VIEW

    //public arena (Arena arena, TerminalScreen screen){
    //this.screen = screen;
    //this.arena = arena; }

    //VIEW
    Hitmarker hitmarker = new Hitmarker(35,17);
    //public arena (Arena arena, TerminalScreen screen){
    //this.screen = screen;
    //this.arena = arena; }

    public void draw(Screen screen) throws IOException {
        TextGraphics tg = screen.newTextGraphics();
        screen.clear();
        tg.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        tg.fill(' ');
        //viewComponents.drawIsland();
        //viewComponents.drawBoat();
        //viewComponent.drawPowerup();


        for(Border border : borders)
            border.draw(tg);

        for(Isle isles : isles)
            isles.draw(tg);

        Isle isle = new Isle();
        List<Integer> corners = isle.find_corners(isles);

        Player player = new Player();
        player.draw(tg,corners);

        for (Ship ship: ships)
            ship.draw(tg);

        hitmarker.draw(tg);

        screen.refresh();
    }

    private List<Border> createBorders(){
        List<Border> borders = new ArrayList<>();

        for(int c=0; c < width; c++){
            borders.add(new Border(c, 0));
            borders.add(new Border(c, height-1));
        }

        for(int r=0; r < height; r++){
            borders.add(new Border(0, r));
            borders.add(new Border(width-1, r));
        }

        return borders;
}

    private List<Isle> createIsle(){
        List<Isle> isles = new ArrayList<>();
        //isles.add(new Isle(20,20));
        //isles.add(new Isle(10,10));
        isles.add(new Isle(10,10));
        isles.add(new Isle(10,11));
        isles.add(new Isle(10,12));
        isles.add(new Isle(11,10));
        isles.add(new Isle(11,11));
        isles.add(new Isle(11,12));
        isles.add(new Isle(12,10));
        isles.add(new Isle(12,11));
        isles.add(new Isle(12,12));
        isles.add(new Isle(13,10));
        isles.add(new Isle(13,11));
        isles.add(new Isle(13,12));

        return isles;
    }

    public void hitmarkerMoveUp() {
        hitmarker.setY(hitmarker.getY() - 1);
    }

    public void hitmarkerMoveDown() {
        hitmarker.setY(hitmarker.getY() + 1);
    }

    public void hitmarkerMoveLeft() {
        hitmarker.setX(hitmarker.getX() - 1);
    }

    public void hitmarkerMoveRight() {
        hitmarker.setX(hitmarker.getX() + 1);
    }

    public void shipMoveUp(Ship ship) {
        ship.setY(ship.getY() - 1);
        ship.setDirection("v");
    }

    public void shipMoveDown(Ship ship) {
        ship.setY(ship.getY() + 1);
        ship.setDirection("v");
    }

    public void shipMoveLeft(Ship ship) {
        ship.setX(ship.getX() - 1);
        ship.setDirection("h");
    }

    public void shipMoveRight(Ship ship) {
        ship.setX(ship.getX() + 1);
        ship.setDirection("h");
    }

    private ArrayList<Ship> createShips() {
        ArrayList<Ship> ships = new ArrayList<>();

        ships.add(new Ship(3, "v", 3, 3));
        ships.add(new Ship(3, "v", 5, 20));
        ships.add(new Ship(4, "h", 55, 20));
        ships.add(new Ship(5, "h", 45, 30));

        return ships;
    }

    public boolean shipHits(Ship ship) {
        for (int i = 0; i < ship.getCoord().size(); i += 2) {
            if (ship.getCoord().get(i) == hitmarker.getX() && ship.getCoord().get(i+1) == hitmarker.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean shipHitsIsle(Ship ship) {
        for (int i = 0; i < ship.getCoord().size(); i += 2) {
            for (Isle isle : isles) {
                if (ship.getCoord().get(i) == isle.getX() && ship.getCoord().get(i+1) == isle.getY())
                    return true;
            }
        }
        return false;
    }

    public ArrayList<Ship> verifyShipCollisions() {
        ArrayList<Ship> extra = new ArrayList<>();
        for (int i = 0; i < ships.size(); i++) {
            for (int j = i+1; j < ships.size(); j++) {
                for (int k = 0; k < ships.get(i).getCoord().size(); k += 2) {
                    for (int l = 0; l < ships.get(j).getCoord().size(); l += 2) {
                        if (Objects.equals(ships.get(i).getCoord().get(k), ships.get(j).getCoord().get(l)) && Objects.equals(ships.get(i).getCoord().get(k + 1), ships.get(j).getCoord().get(l + 1))) {
                            extra.add(ships.get(i));
                            extra.add(ships.get(j));
                        }
                    }
                }
            }
        }
        return extra;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public List<Isle> getIsles() {
        return isles;
    }

    public static int getWidth() {
        return width1;
    }

    public static int getHeight() {
        return height1;
    }

    private static int height1;
    private static int width1;
    private int height;
    private int width;
    private List<Border> borders;
    private List<Isle> isles;
    private ArrayList<Ship> ships;
}

