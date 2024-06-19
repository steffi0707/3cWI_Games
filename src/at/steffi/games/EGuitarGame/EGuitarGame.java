package at.steffi.games.EGuitarGame;


import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class EGuitarGame extends BasicGame {
    private List<EGuitarActor> actors;
    private Steve steve;
    private Note1 note1;
    private Note2 note2;
    private Note3 note3;
    private Note4 note4;
    private Note5 note5;
    private Note6 note6;
    private Note7 note7;
    public EGuitarGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<EGuitarActor>();
        Steve steve = new Steve();
        Note1 note1 = new Note1();
        Note2 note2 = new Note2();
        Note3 note3 = new Note3();
        Note4 note4 = new Note4();
        Note5 note5 = new Note5();
        Note6 note6 = new Note6();
        Note7 note7 = new Note7();
        this.actors.add(steve);
        this.steve = steve;
        this.actors.add(note1);
        this.actors.add(note2);
        this.actors.add(note3);
        this.actors.add(note4);
        this.actors.add(note5);
        this.actors.add(note6);
        this.actors.add(note7);
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
        this.note4 = note4;
        this.note5 = note5;
        this.note6 = note6;
        this.note7 = note7;

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
