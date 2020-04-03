package src.dev.codemore.tilegame.tiles;

import src.dev.codemore.tilegame.Assets;

public class RockTile extends Tile{

    public RockTile(int id){
        super(Assets.stone, id); 
    }

    @Override
    public boolean isSolid(){
        return true; 
    }
}