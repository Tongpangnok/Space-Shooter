import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuKey implements KeyListener {
    GameMenu gameMenu;
     Sound sound=new Sound();
    MenuKey(GameMenu gameMenu)
    {
        this.gameMenu=gameMenu;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

     int code=e.getKeyCode();
     if(code==KeyEvent.VK_W)
     {
         if(gameMenu.started)
         {
             return;
         }
         sound.setOption();
         sound.playOption();
         if(gameMenu.selected==0)
         {
             gameMenu.selected=1;
         }
         else{
             gameMenu.selected=0;
         }
         gameMenu.repaint();
     }
     if(code==KeyEvent.VK_S)
     {
         sound.setOption();
         sound.playOption();
         if(gameMenu.selected==0)
         {
             gameMenu.selected=1;
         }
         else{
             gameMenu.selected=0;
         }
         gameMenu.repaint();

     }
     if(code==KeyEvent.VK_ENTER)
     {
         gameMenu.started=true;
         sound.setOption2();
         sound.playOption2();
       if(gameMenu.selected==0)
       {
            gameMenu.startGame();
       }
       if(gameMenu.selected==1)
       {
           System.exit(0);
       }
     }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
