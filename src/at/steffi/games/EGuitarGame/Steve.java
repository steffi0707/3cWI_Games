package at.steffi.games.EGuitarGame;

import org.newdawn.slick.*;

public class Steve implements EGuitarActor{

    private Image steveImage;
    private float x,y;

    public Steve() throws SlickException {
        Image tmp = new Image("EGuitarGame/Steve.png");
        this.steveImage = tmp.getScaledCopy(50,60);
        this.x = 100;
        this.y = 100;
    }

    @Override
    public void render(Graphics graphics) {
        steveImage.draw(this.x,this.y);
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