import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Game {
    public Game() {}

    Arena arena = new Arena(70,35);

    public void run(Screen screen) {
        try {
            while(true) {
                arena.draw(screen);
                com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
                processKey(key);

                if (key.getKeyType() == KeyType.EOF)
                    break;
                /*
                if(arena.verifyMonsterCollisions()){
                    screen.close();
                    break;
                }

                if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                    screen.close();

                arena.moveMonsters();
                if(arena.verifyMonsterCollisions()){
                    screen.close();
                    break;
                }
                 */
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    private void processKey(com.googlecode.lanterna.input.KeyStroke key){
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp    -> arena.hitmarkerMoveUp();
            case ArrowDown  -> arena.hitmarkerMoveDown();
            case ArrowLeft  -> arena.hitmarkerMoveLeft();
            case ArrowRight -> arena.hitmarkerMoveRight();
        }
    }
}
