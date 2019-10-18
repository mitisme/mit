import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
   int velX;
   int velY;

   Handler handler; 
   
   public Player(int x, int y, ID id, Handler handler) {
      super(x,y,id);
      this.handler = handler;
   }
   
   public void tick() {
      x += velX;
      y += velY;
      
      collision();
      
      if(handler.isUp()) velY = -3;
      else if(!handler.isDown()) velY =0;
   
      if(handler.isDown()) velY = 3;
      else if(!handler.isUp()) velY =0;
   
      if(handler.isLeft()) velX = -3;
      else if(!handler.isRight()) velX =0;
   
      if(handler.isRight()) velX = 3;
      else if(!handler.isLeft()) velX =0;
      
   
   }
   private void collision() {
      for(int i = 0; i < handler.object.size(); i++) {
         GameObject tempObject = handler.object.get(i);
         
         //if(tempObject.getId() == ID.Meteor) {
           
            //if (getBounds.intersects(tempObject.getBounds())) {
               //x = 450;
               //y = 400;
            //}
         //}
      }
   }
   
   public void render(Graphics g) {
      Random rand = new Random();
      int e = rand.nextInt(255)+1;
      int w = rand.nextInt(255) + 1;
      int q = rand.nextInt(255) + 1;
      int s = rand.nextInt(5)+5;
   
      g.setColor(new Color(255,w,20));
      g.fillRect(x, y, 40, 20);
      
   }
   
   public Rectangle getBounds() {
      return new Rectangle(x, y, 40,20);
   }
}
      
