package src.dev.codemore.tilegame;

import java.awt.Graphics;

public class MenuState extends State {

    public MenuState(Game game){
        super(game);
    }

    @Override
    public void tick() {
         

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.dirt, 0, 0, null); 

    }


}