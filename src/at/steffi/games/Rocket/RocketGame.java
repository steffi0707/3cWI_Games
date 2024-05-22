package at.steffi.games.Rocket;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class RocketGame extends BasicGame{
        private List<ActorRocket> actors;
        private Rocket rocket;

        public RocketGame(String title) {
            super(title);
        }

        @Override
        public void init(GameContainer gameContainer) throws SlickException {
            this.actors = new ArrayList<ActorRocket>();
            Rocket rocket = new Rocket();
            this.actors.add(rocket);
            this.rocket = rocket;
        }


        @Override
        public void update(GameContainer gameContainer, int delta) throws SlickException {

        }






        @Override
        public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
            for (ActorRocket actor:this.actors) {
                actor.render(graphics);
            }
        }

        public static void main(String[] argv) {
            try {
                AppGameContainer container = new AppGameContainer(new at.steffi.games.Rocket.RocketGame("RocketGame"));
                container.setDisplayMode(800,600,false);
                container.start();
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }






}
