package at.steffi.games.firstgame;

import org.newdawn.slick.*;

public class Circle extends BasicGame {
    private float x;
    private float y;
    private float speed;

    public Circle(String title) {
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

        this.y += (float)delta/speed;
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawArc(this.x, this.y, 50, 50, 100, 500);
        graphics.drawString("Hello you!", 50, 50);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Circle("Circle"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}