package at.steffi.games.EGuitarGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface EGuitarActor {
    void render(Graphics graphics);

    void update(GameContainer gameContainer, int delta);
}
