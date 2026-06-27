import java.awt.*;

public class UI {
    GamePanel panel;
    String text;
    UI(GamePanel panel){
        this.panel=panel;
        text="Points:";
    }
    void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,40));
        g.drawString(text+panel.point,50,50);
    }
}
