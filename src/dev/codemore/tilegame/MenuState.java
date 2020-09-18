package src.dev.codemore.tilegame;

import java.awt.Graphics;

import src.dev.codemore.tilegame.ui.ClickListener;
import src.dev.codemore.tilegame.ui.UIImageButton;
import src.dev.codemore.tilegame.ui.UIManager;

import java.awt.Color;


public class MenuState extends State {
	
	private UIManager uiManager;

    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler); 
        handler.getMouseManager().setUIManager(uiManager);
        
        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btb_start, new ClickListener() {
        	public void onClick() {
        		State.setState(handler.getGame().gameState);
        	}
        }));
    }

    @Override
    public void tick() {
    	uiManager.tick();

    }

    @Override
    public void render(Graphics g) {
    	uiManager.render(g);

    }


}