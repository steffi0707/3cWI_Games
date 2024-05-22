package at.steffi.games.Rocket;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface ActorRocket {
    void render(Graphics graphics);

    void update(GameContainer gameContainer, int delta);
}
