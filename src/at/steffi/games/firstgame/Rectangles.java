package at.steffi.games.firstgame;

import org.newdawn.slick.*;

public class Rectangles extends BasicGame {
    private boolean isFacingRight;
    private boolean isFacingDown;
    private float rectx;
    private float recty;
    private boolean isGoingDown;
    private float arcx;
    private float arcy;
    private boolean isGoingRight;
    private float ovalx;
    private float ovaly;
    private float speed;


    public Rectangles(String title) {
        super(title);
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.rectx = 100;
        this.recty = 100;
        this.isFacingDown = true;
        this.isFacingRight = true;
        this.arcx = 0;
        this.arcy = 0;
        this.isGoingDown = true;
        this.ovalx = 0;
        this.ovaly = 0;
        this.isGoingRight = true;
        this.speed = 10.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        //Circle
        if(isGoingDown){
            this.arcy += (float)delta/speed;
        }
        else{
            this.arcy -= (float)delta/speed;
        }
        if(this.arcy >= 550){
            isGoingDown = false;
        }
        if (this.arcy <= 0){
            isGoingDown = true;
        }

        //Oval
        if(isGoingRight){
            this.ovalx += (float)delta/speed;
        }
        else{
            this.ovalx -= (float)delta/speed;
        }
        if(this.ovalx >= 750){
            isGoingRight = false;
        }
        if (this.ovalx <= 0) {
            isGoingRight = true;
        }

        //Rectangle
        if(isFacingRight){
            this.rectx += (float)delta/speed;
        }
        else if (isFacingDown) {
            this.recty += (float)delta/speed;
        }
        else{
            this.rectx -= (float) delta/speed;
        }


        if(this.rectx >= 650){
            isFacingRight = false;
        }
        if (this.recty >= 450){
            isFacingDown = false;
        }
        if (this.rectx <= 100){
            isFacingRight = true;
        }
        if (this.recty <= 100){
            isFacingDown = true;
        }


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.rectx, this.recty, 50, 50);
        graphics.drawArc(this.arcx, this.arcy, 50, 50, 100, 500);
        graphics.drawOval(this.ovalx, this.ovaly, 50, 25, 75);
        graphics.drawString("Hello you!", 50, 50);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}

//ich arbeite nicht mehr weiter an dieser aufgabe da es zu lange braucht
