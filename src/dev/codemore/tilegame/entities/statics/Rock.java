package src.dev.codemore.tilegame.entities.statics;

import java.awt.Graphics;

import src.dev.codemore.tilegame.Assets;
import src.dev.codemore.tilegame.Handler;
import src.dev.codemore.tilegame.items.Item;
import src.dev.codemore.tilegame.tiles.Tile;

public class Rock extends StaticEntity{
	
	public Rock(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT); 
		
		bounds.x = 3;
		bounds.y = (int)(height /2f);
		bounds.width = width - 6;
		bounds.height = (int)(height - height/2f); 
	}
	
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int) x, (int) y));
    }

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.rock, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);		
	}
	
}
