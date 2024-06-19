package at.steffi.games.EGuitarGame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class EGuitarGame extends BasicGame {
    private List<EGuitarActor> actors;
    private Steve steve;
    private Note note;
    public EGuitarGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<EGuitarActor>();
        Steve steve = new Steve();
        Note note = new Note();
        this.actors.add(steve);
        this.steve = steve;
        this.actors.add(note);
        this.note = note;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (EGuitarActor actor: this.actors) {
            actor.update(gameContainer, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.setBackground(Color.lightGray);
        for (EGuitarActor actor: this.actors){
            actor.render(graphics);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        System.out.println(key);

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new at.steffi.games.EGuitarGame.EGuitarGame("EGuitarGame"));
            container.setDisplayMode(800,600,false);
            container.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
