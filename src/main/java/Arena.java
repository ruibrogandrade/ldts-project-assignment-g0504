import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int height;
    private int width;

    public Arena(int width, int height) {
        this.height = height;
        this.width = width;
        borders = createBorders();
        isles = createIsle();
    }

    //VIEW

    //public arena (Arena arena, TerminalScreen screen){
    //this.screen = screen;
    //this.arena = arena; }

    public void draw(Screen screen) throws IOException {
        TextGraphics tg = screen.newTextGraphics();;
        screen.clear();
        tg.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        tg.fill(' ');
        //tg.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
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

    public List<Isle> createIsle(){
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

        return isles;
    }



    private List<Border> borders;
    private List<Isle> isles;
}

