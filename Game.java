import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
   
   private static final long serialVersionUID = 1L;
   
   private boolean isRunning = false;
   private Thread thread;
   private Handler handler;
   //Creates background window size and holds objects by handler
   public Game() {
     Screen(1280, 720, "Deed", this);
      start();
      
      handler = new Handler();
      addKeyListener(new KeyInput(handler));
      handler.addObject(new Player(425, 745, ID.Player, handler));
      
   }

//starts a new thread
   private void start() {
      isRunning = true;
      thread = new Thread(this);
      thread.start();
   }
   // Stops current thread, and catches exceptions
   private void stop() {
      isRunning = false;
      try {
         thread.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
   //Infinite game loop
   public void run() {
      this.requestFocus();
      long lastTime = System.nanoTime();
      double amountOfTicks = 60.0;
      double ns = 1000000000 / amountOfTicks;
      double delta = 0;
      long timer = System.currentTimeMillis();
      int frames = 0;
      while(isRunning) {
         long now = System.nanoTime();
         delta += (now - lastTime) / ns;
         lastTime = now;
         while(delta >= 1) {
            tick();
            //updates++;
            delta--;
         }
         render();
         frames++;
         
         if(System.currentTimeMillis() - timer > 1000) {
            timer += 1000;
            frames = 0;
            //updates = 0;
         }
      }
      stop();
   }
   
   public void tick() {
      handler.tick();
   }
   //Holds extra frames before showing (3 extra)
   public void render() {
      BufferStrategy bs = this.getBufferStrategy();
      if(bs == null) {
         this.createBufferStrategy(5);
         return;
      }
      
      Graphics g = bs.getDrawGraphics();
      /////////////////Renders background first, then handlers///////////////////
      
      g.setColor(Color.black);
      g.fillRect(0,0,1280,720);
      
      handler.render(g);
      
      /////////////////Updates graphics////////////////////
      g.dispose();
      bs.show();
            
   }
   public static void main(String args[]) {
      new Game();
   }

}