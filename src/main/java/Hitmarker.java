import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hitmarker {
    private int x;
    private int y;

    public Hitmarker(int x, int y) {
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
        screen.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        screen.setForegroundColor(TextColor.ANSI.BLACK);
        screen.putString(getX(),getY(), ("X"), SGR.BLINK);
        screen.setBackgroundColor(TextColor.ANSI.DEFAULT);
        screen.setForegroundColor(TextColor.ANSI.DEFAULT);
    }

}
