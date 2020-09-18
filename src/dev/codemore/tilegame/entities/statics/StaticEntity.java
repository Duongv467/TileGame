package src.dev.codemore.tilegame.entities.statics;

import src.dev.codemore.tilegame.Handler;
import src.dev.codemore.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity{
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height); 
	}
}
