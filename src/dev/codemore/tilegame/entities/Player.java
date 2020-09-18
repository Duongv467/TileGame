package src.dev.codemore.tilegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.codemore.tilegame.gfx.Animation;
import dev.codemore.tilegame.inventory.Inventory;
import javafx.scene.paint.Color;
import src.dev.codemore.tilegame.Assets;
import src.dev.codemore.tilegame.Game;
import src.dev.codemore.tilegame.Handler;

public class Player extends Creature {
	
	//Animation
	private Animation animDown, animUp, animLeft, animRight;
	private long lastAttackTimer, attackCooldown = 100, attackTimer = attackCooldown;
	//Inventory
	private Inventory inventory; 

    public Player(Handler handler,float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
     
        bounds.x = 22;
        bounds.y = 44;
        bounds.width = 19;
        bounds.height = 19;
        
        //Animations
        animDown = new Animation(500,Assets.player_down);
        animUp = new Animation(500,Assets.player_up);
        animLeft = new Animation(500,Assets.player_left);
        animRight = new Animation(500,Assets.player_right);

        //Inventory
        inventory = new Inventory(handler); 
        
        
    }
    
    public void die() {
    	System.out.println("You lose"); 
    }

    @Override
    public void tick() {
    	//Animations
    	animDown.tick();
    	animUp.tick();
    	animLeft.tick();
    	animRight.tick();
    	 
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        
        //Attack
        checkAttacks(); 

        //Inventory
        inventory.tick();  
    }
    
    public void checkAttacks() {
    	attackTimer += System.currentTimeMillis() - lastAttackTimer;
    	lastAttackTimer = System.currentTimeMillis(); 
    	if(attackTimer < attackCooldown) {
    		return; 
    	}
    	
    	if(inventory.isActive()) {
    		return; 
    	}
    	
    	Rectangle cb = getCollisionBounds(0,0); 
    	
    	Rectangle ar = new Rectangle(); 
    	int arSize = 20; 
    	ar.width = arSize;
    	ar.height = arSize;  
    	
    	if(handler.getKeyManager().aUp) {
    		 ar.x = cb.x + cb.width/2 - arSize/2;
    		 ar.y = cb.y - arSize; 
    	} else if(handler.getKeyManager().aDown) {
   		 ar.x = cb.x + cb.width/2 - arSize/2;
   		 ar.y = cb.y - cb.height; 
    	} else if(handler.getKeyManager().aLeft) {
      		 ar.x = cb.x - arSize;
       		 ar.y = cb.y + cb.height/2 -arSize/2; 
        } else if(handler.getKeyManager().aUp) {
          		 ar.x = cb.x + cb.width;
           		 ar.y = cb.y + cb.height/2 -arSize/2; 
        }  else {
        	return; 
        }
    	
    	attackTimer = 0; 
    	
    	for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
    		if(e.equals(this))
    			continue;
    		if(e.getCollisionBounds(0,0).intersects(ar)) {
    			e.hurt(1);
    			return; 
    		}
    	}
   
    }



    private void getInput(){
    	if(inventory.isActive()) {
    		return; 
    	}
    	
        xMove = 0;
        yMove = 0; 

        if(handler.getKeyManager().up)
            yMove = -speed; 
        if(handler.getKeyManager().down)
            yMove = speed; 
        if(handler.getKeyManager().left)
            xMove = -speed; 
        if(handler.getKeyManager().right)
            xMove = speed; 

    }

    @Override
    public void render(Graphics g) {
       g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null); 

       
//       g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//    		   (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }
    
    
    public void postRender(Graphics g) {
    	inventory.render(g);
    }
    
    private BufferedImage getCurrentAnimationFrame() {
    	if(xMove < 0) {
    		return animLeft.GetCurrentFrame();
    	}else if(xMove > 0) {
    		return animRight.GetCurrentFrame();
    	}else if(yMove < 0) {
    		return animUp.GetCurrentFrame();
    	}else {
    		return animDown.GetCurrentFrame(); 
    	}
    }

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}


   


    


}