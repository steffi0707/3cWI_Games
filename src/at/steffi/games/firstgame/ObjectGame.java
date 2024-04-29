package at.steffi.games.firstgame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class ObjectGame extends BasicGame {
    private List<Rectangle> rectangles;
    private List<Circle> circles;

    public enum Direction {RIGHT, DOWN, LEFT, UP}
    public enum Direction1 {RIGHT, DOWN, LEFT, UP}
    public enum Direction2 {RIGHT, DOWN, LEFT, UP}
    private float recx;
    private float recy;
    private float ovx;
    private float ovy;
    private float circx;
    private float circy;
    private float Speed;
    private Direction actualDirectionRec = Direction.RIGHT;
    private Direction1 actualDirectionOv = Direction1.RIGHT;
    private Direction2 actualDirectionCirc = Direction2.DOWN;




    public ObjectGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.rectangles = new ArrayList<>();
        this.circles = new LinkedList<>();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(600), random.nextInt(600), random.nextInt(50));
            rectangles.add(rectangle);
        }
        for (int i = 0; i < 50; i ++) {
            Circle circle = new Circle();
            this.circles.add(circle);
        }

        this.recx = 100;
        this.recy = 100;
        this.ovy = 0;
        this.ovx = 100;
        this.circx = 0;
        this.Speed = 10.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

       for (Rectangle rectangle:this.rectangles){
           rectangle.update(delta);
       }

       for (Circle circle: this.circles){
           circle.update(delta);
       }

        double windowBoarderHorizontalRight = gameContainer.getWidth() * 0.8;
        double windowBoarderHorizontalLeft = gameContainer.getWidth() * 0.1;
        double windowBoarderVerticalDown = gameContainer.getHeight() * 0.8;
        double windowBoarderVerticalUp = gameContainer.getHeight() * 0.1;

        if (actualDirectionRec==Direction.RIGHT){
            this.recx = moveRight(this.recx, delta);
            if (this.recx > windowBoarderHorizontalRight){
                this.actualDirectionRec = Direction.DOWN;

            }
        }
        if (actualDirectionRec==Direction.DOWN){
            this.recy = moveDown(this.recy, delta);
            if (this.recy> windowBoarderVerticalDown){
                this.actualDirectionRec = Direction.LEFT;
            }
        }
        if (actualDirectionRec==Direction.LEFT){
            this.recx = moveLeft(this.recx, delta);
            if (this.recx < windowBoarderHorizontalLeft ){
                this.actualDirectionRec = Direction.UP;
            }
        }

        if (actualDirectionRec==Direction.UP){
            this.recy = moveUp(this.recy, delta);
            if (recy < windowBoarderVerticalUp){
                this.actualDirectionRec = Direction.RIGHT;
            }
        }




        if (actualDirectionOv==Direction1.RIGHT){
            this.ovx = moveRight(this.ovx, delta);
            if (this.ovx>windowBoarderHorizontalRight){
                this.actualDirectionOv = Direction1.LEFT;
            }


        }

        if (actualDirectionOv==Direction1.LEFT){
            this.ovx = moveLeft(this.ovx, delta);
            if (this.ovx<=windowBoarderHorizontalLeft){
                this.actualDirectionOv = Direction1.RIGHT;
            }
        }


        if(actualDirectionCirc==Direction2.DOWN){
            this.circy = moveDown(this.circy,delta);
            if(this.circy >= windowBoarderVerticalDown){
                this.actualDirectionCirc = Direction2.UP;
            }
        }

        if(actualDirectionCirc==Direction2.UP){
            this.circy = moveUp(this.circy,delta);
            if(this.circy <= windowBoarderVerticalUp){
                this.actualDirectionCirc = Direction2.DOWN;
            }
        }



        /*if (this.ovx < 800 ){
            actualDirection = true;
        }

        else if (this.ovx > 800){
            actualDirection = false;
        }


        if (actualDirection) {
            this.ovx = moveRight(this.ovx, delta);
            System.out.println("x" + this.ovx);
            System.out.println("Going Right");
        }

        else if (!actualDirection) {
            this.ovx = moveLeft(this.ovx, delta);
            System.out.println("x" + this.ovx);
            System.out.println("Going Left");
        }*/

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Rectangle rectangle:this.rectangles){
            rectangle.render(graphics);
        }

        for (Circle circle: this.circles){
            circle.render(graphics);
        }

        graphics.drawRect(this.recx,this.recy,50,50);
        graphics.drawOval(this.ovx, this.ovy, 50, 25);
        graphics.drawOval(this.circx, this.circy, 50,50);
        graphics.drawString("Hello World!", 50, 50);

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectGame("Rectangles"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }





    public float moveRight(float xChord, int delta){
        return xChord + (float)delta/this.Speed;
    }

    public float moveLeft(float xChord, int delta){
        return xChord -= (float)delta/this.Speed;
    }

    public float moveUp(float yChord, int delta) {
        return yChord -= (float) delta / this.Speed;
    }

    public float moveDown(float yChord, int delta){
        return yChord += (float)delta/this.Speed;
    }



    /*
        if (this.ovx >= 700){
            this.isFacingRight = false;
        }

        if(this.ovx <= 100){
            this.isFacingRight = true;
        }

        if (this.isFacingRight) {
            System.out.println(this.ovx + " <= 700");
            this.ovx = (this.ovx, delta);
        }

        if (!this.isFacingRight) {
            System.out.println(this.ovx + " >= 100");
            this.ovx = Move(this.ovx, -delta);

        public float Move(float yChord, int delta){
        return yChord + (float)delta/this.recSpeed;
    }*/

}