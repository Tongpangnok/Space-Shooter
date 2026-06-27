import javax.swing.*;
import java.awt.*;

public class GameMenu extends JPanel {
     Rectangle start;
     Rectangle exit;
     MenuKey menuKey=new MenuKey(this);
     int selected=0;
     JFrame window;
     boolean started=false;
    GameMenu(JFrame window){
        this.setPreferredSize(new Dimension(500,500));
        this.setFocusable(true);
        this.window=window;
        start=new Rectangle(170,200,200,60);
        exit=new Rectangle(170,300,200,60);
        this.addKeyListener(menuKey);

    }
    void startGame(){
window.remove(this);
GamePanel panel=new GamePanel(window);
window.add(panel);
panel.setBackground(Color.black);
window.pack();
window.revalidate();
window.repaint();
panel.gameLoop();
panel.requestFocusInWindow();
    }



    @Override
  protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.drawString("SPACE",170,50);


        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.drawString("SHOOTER",130,100);

        g.setColor(Color.red);

        if(selected==0) {
            g.drawRect(start.x, start.y, start.width, start.height);
        }
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.drawString("START GAME",start.x,start.y+40);


        g.setColor(Color.red);
        if(selected==1) {
            g.drawRect(exit.x, exit.y, exit.width, exit.height);
        }
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.setColor(Color.white);
        g.drawString("EXIT GAME",exit.x,exit.y+40);
    }
}
