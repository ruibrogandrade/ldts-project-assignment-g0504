package View;

import com.googlecode.lanterna.screen.Screen;

public abstract class AbstractView implements View {

    protected Screen screen;

    public AbstractView(Screen screen) {
        this.screen = screen;
    }
}
