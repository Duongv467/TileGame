package src.dev.codemore.tilegame.tiles;

import src.dev.codemore.tilegame.Assets;

public class DirtTile extends Tile{

    public DirtTile(int id){
        super(Assets.dirt, id); 
    }

    @Override
    public boolean isSolid(){
        return true; 
    }
}