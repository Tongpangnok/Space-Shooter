import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameOver implements KeyListener{
    GamePanel gamePanel;
    int selected=0;
    JFrame window;
    GameMenu menu;
    public boolean begin=false;
    Sound sound=new Sound();
    public boolean start=true;
    GameOver(GamePanel gamePanel,JFrame window,GameMenu menu){
        this.gamePanel=gamePanel;
        this.window=window;
        this.menu=new GameMenu(window);

    }
    void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial",Font.BOLD,70));
        g.drawString("GAME OVER",50,60);
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.drawString("FINAL SCORE:"+gamePanel.point,20,150);
        g.drawString("BEST SCORE:"+gamePanel.bestScore,20,200);

        g.setColor(Color.red);

        if(selected==0) {
            g.drawRect(140, 300, 300, 60);
        }
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.drawString("RESTART GAME",140,300+40);


        g.setColor(Color.red);
        if(selected==1) {
            g.drawRect(140, 400, 300, 60);
        }
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.setColor(Color.white);
        g.drawString("EXIT GAME",140,400+40);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
        {
            if(!begin)
            {
                return;
            }
            int code=e.getKeyCode();
            if(code==KeyEvent.VK_W)
            {
                sound.setOption();
                sound.playOption();

                if(selected==0)
                {
                    selected=1;
                }
                else{
                    selected=0;
                }
                gamePanel.repaint();
            }
            if(code==KeyEvent.VK_S)
            {
                sound.setOption();
                sound.playOption();
                if(selected==0)
                {
                    selected=1;
                }
                else{
                    selected=0;
                }
                gamePanel.repaint();

            }
            if(code==KeyEvent.VK_ENTER)
            {
                sound.setOption2();
                sound.playOption2();
                if(selected==0)
                {
                    start=false;
                 gamePanel.resetGame();
                }
                if(selected==1)
                {
                    System.exit(0);
                }
            }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



}
