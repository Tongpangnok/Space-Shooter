import java.awt.*;

public class HpBar {
    Rectangle hp;
    Rectangle bar;
    Object object=new Object();
    HpBar(Object object){
        this.object=object;
        hp=new Rectangle(object.rect.x-5,object.rect.y-10,60,6);

        bar=new Rectangle(object.rect.x-5,object.rect.y-10,60,6);
    }
    void draw(Graphics g){
        g.setColor(Color.red);
        g.fillRect(bar.x,bar.y,bar.width,bar.height);
        g.setColor(Color.green);
        g.fillRect(hp.x,hp.y,hp.width, hp.height);

    }
}
