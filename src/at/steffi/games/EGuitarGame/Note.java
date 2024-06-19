package at.steffi.games.EGuitarGame;

import org.newdawn.slick.*;

public class Note implements EGuitarActor{

    private final Image noteImage;
    private float x,y;

    public Note() throws SlickException {
        Image tmp = new Image("testdata/guitar/Note 1.png");
        this.noteImage = tmp.getScaledCopy(360,410);
        this.x = 100;
        this.y = 10;
    }

    @Override
    public void render(Graphics graphics) {
        noteImage.draw(this.x,this.y);
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