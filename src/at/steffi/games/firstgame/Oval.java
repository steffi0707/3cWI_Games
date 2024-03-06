package at.steffi.games.firstgame;

import org.newdawn.slick.*;

public class Oval extends BasicGame {
    private float x;
    private float y;
    private float speed;

    public Oval(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.x = 0;
        this.y = 0;
        this.speed = 10.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.x += (float)delta/speed;

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawOval(this.x, this.y, 50, 25, 75);
        graphics.drawString("Hello you!", 50, 50);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Oval("Oval"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
