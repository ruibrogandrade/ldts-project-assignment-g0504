package Model;

import java.util.ArrayList;
import java.util.List;

public class ArenaModelFactory {

    int width;
    int height;

    public ArenaModelFactory(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Arena_Model createLvl1Arena() {
        List<Border_Model> borders = createBorders();
        List<Isle_Model> isles = createIsleLvL1();
        List<Ship_Model> ships = createShipsLvL1();

        return new Arena_Model(width, height, borders, isles, ships);
    }

    public Arena_Model createLvl2Arena() {
        List<Border_Model> borders = createBorders();
        List<Isle_Model> isles = createIsleLvL2();
        List<Ship_Model> ships = createShipsLvL2();

        return new Arena_Model(width, height, borders, isles, ships);
    }

    public Arena_Model createLvl3Arena() {
        List<Border_Model> borders = createBorders();
        List<Isle_Model> isles = createIsleLvL3();
        List<Ship_Model> ships = createShipsLvL3();

        return new Arena_Model(width, height, borders, isles, ships);
    }

    public Arena_Model createLvl4Arena() {
        List<Border_Model> borders = createBorders();
        List<Isle_Model> isles = createIsleLvL4();
        List<Ship_Model> ships = createShipsLvL4();

        return new Arena_Model(width, height, borders, isles, ships);
    }

    public Arena_Model createLvl5Arena() {
        List<Border_Model> borders = createBorders();
        List<Isle_Model> isles = createIsleLvL5();
        List<Ship_Model> ships = createShipsLvL5();

        return new Arena_Model(width, height, borders, isles, ships);
    }

    private List<Border_Model> createBorders(){
        List<Border_Model> borders = new ArrayList<>();

        for(int c=0; c < this.width; c++){
            borders.add(new Border_Model(c, 0));
            borders.add(new Border_Model(c, this.height-1));
        }

        for(int r=0; r < this.height; r++){
            borders.add(new Border_Model(0, r));
            borders.add(new Border_Model(this.width-1, r));
        }

        return borders;
    }


    private List<Isle_Model> createIsleLvL1(){
        List<Isle_Model> isles = new ArrayList<>();

        isles.add(new Isle_Model(1,1));

        return isles;
    }

    private List<Isle_Model> createIsleLvL2(){
        List<Isle_Model> isles = new ArrayList<>();

        isles.add(new Isle_Model(1, 10));
        isles.add(new Isle_Model(1, 11));
        isles.add(new Isle_Model(1, 12));
        isles.add(new Isle_Model(2, 10));
        isles.add(new Isle_Model(2,11));
        isles.add(new Isle_Model(2,12));
        isles.add(new Isle_Model(3,10));
        isles.add(new Isle_Model(3,11));
        isles.add(new Isle_Model(3,12));
        isles.add(new Isle_Model(4,10));
        isles.add(new Isle_Model(4,11));
        isles.add(new Isle_Model(4,12));

        return isles;
    }

    private List<Isle_Model> createIsleLvL3(){
        List<Isle_Model> isles = new ArrayList<>();
        //isles.add(new Isle(20,20));
        //isles.add(new Isle(10,10));
        isles.add(new Isle_Model(33,1));
        isles.add(new Isle_Model(34,1));
        isles.add(new Isle_Model(35,1));
        isles.add(new Isle_Model(36,1));
        isles.add(new Isle_Model(37,1));
        isles.add(new Isle_Model(34,2));
        isles.add(new Isle_Model(35,2));
        isles.add(new Isle_Model(36,2));
        isles.add(new Isle_Model(35,3));

        return isles;
    }

    private List<Isle_Model> createIsleLvL4(){
        List<Isle_Model> isles = new ArrayList<>();
        //isles.add(new Isle(20,20));
        //isles.add(new Isle(10,10));
        isles.add(new Isle_Model(33,14));
        isles.add(new Isle_Model(33,15));
        isles.add(new Isle_Model(33,16));
        isles.add(new Isle_Model(34,14));
        isles.add(new Isle_Model(34,15));
        isles.add(new Isle_Model(34,16));
        isles.add(new Isle_Model(35,14));
        isles.add(new Isle_Model(35,15));
        isles.add(new Isle_Model(35,16));
        isles.add(new Isle_Model(36,14));
        isles.add(new Isle_Model(36,15));
        isles.add(new Isle_Model(36,16));

        return isles;
    }

    private List<Isle_Model> createIsleLvL5(){
        List<Isle_Model> isles = new ArrayList<>();
        //isles.add(new Isle(20,20));
        //isles.add(new Isle(10,10));
        isles.add(new Isle_Model(32,12));
        isles.add(new Isle_Model(33,12));
        isles.add(new Isle_Model(34,12));
        isles.add(new Isle_Model(35,12));
        isles.add(new Isle_Model(36,12));
        isles.add(new Isle_Model(37,12));
        isles.add(new Isle_Model(38,12));
        isles.add(new Isle_Model(33,11));
        isles.add(new Isle_Model(34,11));
        isles.add(new Isle_Model(35,11));
        isles.add(new Isle_Model(36,11));
        isles.add(new Isle_Model(37,11));
        isles.add(new Isle_Model(34,10));
        isles.add(new Isle_Model(35,10));
        isles.add(new Isle_Model(36,10));
        isles.add(new Isle_Model(35,9));
        isles.add(new Isle_Model(33,13));
        isles.add(new Isle_Model(34,13));
        isles.add(new Isle_Model(35,13));
        isles.add(new Isle_Model(36,13));
        isles.add(new Isle_Model(37,13));
        isles.add(new Isle_Model(34,14));
        isles.add(new Isle_Model(35,14));
        isles.add(new Isle_Model(36,14));
        isles.add(new Isle_Model(35,15));

        return isles;
    }

    private ArrayList<Ship_Model> createShipsLvL1() {
        ArrayList<Ship_Model> ships = new ArrayList<>();

        ships.add(new Ship_Model(3, "v", 60, 30));
        ships.add(new Ship_Model(3, "v", 50, 25));
        ships.add(new Ship_Model(4, "h", 55, 20));

        return ships;
    }
    private ArrayList<Ship_Model> createShipsLvL2() {
        ArrayList<Ship_Model> ships = new ArrayList<>();

        ships.add(new Ship_Model(3, "v", 30, 10));
        ships.add(new Ship_Model(3, "v", 35, 22));
        ships.add(new Ship_Model(4, "h", 10, 30));
        ships.add(new Ship_Model(5, "h", 45, 25));


        return ships;
    }
    private ArrayList<Ship_Model> createShipsLvL3() {
        ArrayList<Ship_Model> ships = new ArrayList<>();

        ships.add(new Ship_Model(3, "v", 3, 3));
        ships.add(new Ship_Model(3, "v", 60, 3));
        ships.add(new Ship_Model(3, "v", 5, 20));
        ships.add(new Ship_Model(4, "h", 55, 20));
        ships.add(new Ship_Model(5, "h", 45, 30));
        ships.add(new Ship_Model(5, "v", 45, 10));

        return ships;
    }
    private ArrayList<Ship_Model> createShipsLvL4() {
        ArrayList<Ship_Model> ships = new ArrayList<>();

        ships.add(new Ship_Model(3, "v", 3, 3));
        ships.add(new Ship_Model(3, "v", 5, 20));
        ships.add(new Ship_Model(4, "h", 55, 20));
        ships.add(new Ship_Model(5, "h", 45, 30));
        ships.add(new Ship_Model(5, "v", 13, 15));
        ships.add(new Ship_Model(5, "v", 21, 10));

        return ships;
    }
    private ArrayList<Ship_Model> createShipsLvL5() {
        ArrayList<Ship_Model> ships = new ArrayList<>();

        ships.add(new Ship_Model(3, "v", 3, 3));
        ships.add(new Ship_Model(3, "v", 5, 12));
        ships.add(new Ship_Model(4, "h", 55, 28));
        ships.add(new Ship_Model(5, "h", 45, 33));
        ships.add(new Ship_Model(5, "v", 50, 7));
        ships.add(new Ship_Model(5, "h", 40, 5));
        ships.add(new Ship_Model(5, "v", 24, 5));
        ships.add(new Ship_Model(5, "h", 50, 5));

        return ships;
    }
}
