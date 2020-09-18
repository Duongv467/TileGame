package src.dev.codemore.tilegame.entities.statics;

import java.awt.Graphics;

import src.dev.codemore.tilegame.Assets;
import src.dev.codemore.tilegame.Handler;
import src.dev.codemore.tilegame.items.Item;
import src.dev.codemore.tilegame.tiles.Tile;

public class Tree extends StaticEntity {
	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT); 
		
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f); 
	}
	
	public void die() {
    	handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int) x, (int) y));
    }

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	
}
