import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Arrays;
import java.util.List;

public class Isle {

    private int x;
    private int y;

    public Isle() {}

    public Isle(int x, int y) {
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

    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.ANSI.RED_BRIGHT);
        screen.putString(new TerminalPosition(getX(), getY()), " ");
        screen.setBackgroundColor(TextColor.ANSI.DEFAULT);
    }

    public List<Integer> find_corners(List<Isle> isles) {
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
        List<Integer> result = Arrays.asList(x1,y1,x2,y2);
        return result;
    }
}
