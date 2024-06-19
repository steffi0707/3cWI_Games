package at.steffi.games.EGuitarGame;

import org.newdawn.slick.*;
import java.util.Random;


public class Note6 implements EGuitarActor{

    private final Image note6Image;
    private float x,y;
    private int speed;
    private Random random;

    public Note6() throws SlickException {
        this.random = new Random();
        this.speed = 8;
        Image tmp = new Image("testdata/guitar/Note 6.png");
        this.note6Image = tmp.getScaledCopy(360,410);
        setRandomPosition();
    }

    private void setRandomPosition(){
        this.x = this.random.nextInt(800);
        this.y = this.random.nextInt(600) - 600;
    }
    @Override
    public void render(Graphics graphics) {
        note6Image.draw(this.x,this.y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y += (float)delta/this.speed;
        if (this.y>600){
            setRandomPosition();
        }

    }
}
