import java.awt.*;

public class Bullet {

    public int bulletX;
    public int bulletY;
    public boolean active;
    Rectangle bul;
    GamePanel gp;
    Bullet(GamePanel gp){
        this.gp=gp;
       bulletX=gp.player.x+gp.player.width/2;
       bulletY=gp.player.y;
        bul=new Rectangle(bulletX,bulletY,5,20);
    }
    void draw(Graphics g){

        g.setColor(Color.red);
        g.fillRect(bul.x,bul.y,bul.width,bul.height);
    }
}
