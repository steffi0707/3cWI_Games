package at.steffi.games.Rocket;

import org.newdawn.slick.*;

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
    public void update(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)){
            this.x++;
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)){
            this.x--;
        }

    }


}
