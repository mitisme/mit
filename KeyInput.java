import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput extends KeyAdapter implements KeyListener {

   Handler handler;
   
   public KeyInput(Handler handler ) {
      this.handler = handler;
   }
   
   public void keyPressed(KeyEvent e) {
      
      for (int i = 0; i<handler.object.size(); i++) {
         GameObject tempObject = handler.object.get(i);
         if (tempObject.getId() == ID.Player) {
            if(e.getKeyCode() == KeyEvent.VK_W) handler.setUp(true);
            if(e.getKeyCode() == KeyEvent.VK_S) handler.setDown(true);
            if(e.getKeyCode() == KeyEvent.VK_A) handler.setLeft(true);
            if(e.getKeyCode() == KeyEvent.VK_D) handler.setRight(true);         
         }
      }
   }      
   public void keyReleased(KeyEvent e) {
      for (int i = 0; i<handler.object.size(); i++) {
         GameObject tempObject = handler.object.get(i);
         if (tempObject.getId() == ID.Player) {
            if(e.getKeyCode() == KeyEvent.VK_W) handler.setUp(false);
            if(e.getKeyCode() == KeyEvent.VK_S) handler.setDown(false);
            if(e.getKeyCode() == KeyEvent.VK_A) handler.setLeft(false);
            if(e.getKeyCode() == KeyEvent.VK_D) handler.setRight(false);
         }
      }
   }
}