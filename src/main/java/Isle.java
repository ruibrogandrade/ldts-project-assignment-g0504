import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Isle {

    private int x;
    private int y;

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
        screen.enableModifiers(SGR.BOLD);
        screen.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');
        //screen.putString(new TerminalPosition(getX(), getY()), "/");
    }

}
