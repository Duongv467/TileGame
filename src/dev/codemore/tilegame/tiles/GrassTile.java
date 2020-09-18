package src.dev.codemore.tilegame.tiles;

import src.dev.codemore.tilegame.Assets;

public class GrassTile extends Tile{

    public GrassTile(int id){
        super(Assets.grass, id); 
    }
    
    public boolean isSolid(){
        return false; 
    }
}