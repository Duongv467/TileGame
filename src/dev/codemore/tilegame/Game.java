package src.dev.codemore.tilegame;

import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Graphics; 
import java.awt.image.BufferedImage;
import java.security.Key;

import javafx.scene.image.Image;
import src.dev.codemore.tilegame.input.KeyManager;

public class Game implements Runnable {

    private Display display;
    private int width, height;
    private String title;

    private Thread thread;
    private boolean running; 

    //tell the computer to draw the picture on the screen
    //Buffer is a computer screen within the computer screen
    private BufferStrategy bs;
    private Graphics g; 

    //States
    private State gameState;
    private State menuState;    

    // private BufferedImage test; 
    // private SpriteSheet sheet;

    //Input
    private KeyManager KeyManager;

    
    public void tick(){
        KeyManager.tick();

        if(State.getState() != null){
            State.getState().tick();
        }
    }
  

    public Game(String title, int width, int height) {
        this.height = height;
        this.width = width;
        this.title = title;
        KeyManager = new KeyManager(); 

        
    }

    public void run(){

        init();

        int fps = 60; 
        double timePerTick = 1000000000 / fps; 
        double delta = 0;
        long now;
        long lastTime = System.nanoTime(); 
        long timer = 0;
        long ticks = 0;


        
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick; 
            timer += now - lastTime; 
            lastTime = now; 

            if(delta >= 1){
                tick();
                render();
                ticks++; 
                delta--;  
            }

            if(timer >= 1000000000){
                
                ticks = 0;
                timer = 0;

            }
        }

        stop();
    
    }

    public KeyManager getKeyManager(){
        return KeyManager; 
    }

    


    public void render(){
        // use buffer to prevent the flickering 
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
 
        g = bs.getDrawGraphics();//Graphic allow user to draw to the canvas

        //Clear Screen
        g.clearRect(0, 0, width, height);

        g.clearRect(0,0,3000,2000);

        //Draw here

        if(State.getState() != null){
            State.getState().render(g);
        }
        
        //g.drawImage(sheet.crop(180,0, 180, 180), 5, 5, null);
        //g.drawImage(Assets.grass, x, 10, null);


        //End drawing
        bs.show();
        g.dispose();
    }

    public void init(){
        display = new Display(this.title, this.width, this.height);
        display.getFrame().addKeyListener(KeyManager);
        // test = ImageLoader.loadImage("res/textures/sheet.png");
        // sheet = new SpriteSheet(test);
        Assets.init();

        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);

       
    }

    public synchronized void start() {
        if(running){
            return;
        }
        else{
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop() {
        if(!running) return;

        running = false; 
        try {
            thread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    

}