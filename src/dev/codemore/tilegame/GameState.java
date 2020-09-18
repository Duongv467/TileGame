package src.dev.codemore.tilegame;

import java.awt.Graphics;
import java.io.File;

import src.dev.codemore.tilegame.entities.Player;
import src.dev.codemore.tilegame.entities.statics.Tree;
import src.dev.codemore.tilegame.tiles.World;

public class GameState extends State {

    //private Player player;
    private World world;  
    //private Tree tree;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"src\\dev\\codemore\\tilegame\\res\\worlds\\world1.txt");
        handler.setWorld(world);
        //player = new Player(handler, 100, 100);
        //tree = new Tree(handler, 100, 200);
    }

    @Override
    public void tick() {
        world.tick();
//        player.tick();
//        tree.tick();
    
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
//         player.render(g); 
//         tree.render(g);
         

    }


}