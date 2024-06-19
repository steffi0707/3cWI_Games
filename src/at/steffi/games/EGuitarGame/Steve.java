package at.steffi.games.EGuitarGame;

import org.newdawn.slick.*;

public class Steve implements EGuitarActor{

    private final Image steveImage;
    private float x,y;
    private int speed;

    public Steve() throws SlickException {
        this.speed = 8;
        Image tmp = new Image("testdata/guitar/Steve.png");
        this.steveImage = tmp.getScaledCopy(600,510);
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
        checkCollision(gameContainer);
    }

    private void checkCollision(GameContainer gameContainer) {
        int windowWidth = gameContainer.getWidth();
        float steveWidth = steveImage.getWidth();

        // Begrenzen der Position auf den linken Rand
        if (this.x < 0) {
            this.x = 0;
        }

        // Begrenzen der Position auf den rechten Rand
        if (this.x + steveWidth > windowWidth) {
            this.x = windowWidth - steveWidth;
        }
    }
}
