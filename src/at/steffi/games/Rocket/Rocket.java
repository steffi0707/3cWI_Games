package at.steffi.games.Rocket;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Rocket implements ActorRocket {
    private Image rocketImage;
    private float x,y;


    public Rocket() throws SlickException {
        Image tmp = new Image("testdata/Rocket1.png");
        this.rocketImage = tmp.getScaledCopy(50,60);
        this.x = 100;
        this.y = 100;
    }

    @Override
    public void render(Graphics graphics){
        rocketImage.draw(this.x,this.y);
    }

    @Override
    public void update(int delta) {
        this.x++;
    }


}
