import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Object {
    public boolean alive=true;
    BufferedImage image2;
    Object() {
        try {
            image2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/enemy.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    Rectangle rect=new Rectangle(150,50,50,50);

    void draw(Graphics g)
    {
        g.drawImage(image2,rect.x,rect.y, rect.width, rect.height,null);
    }
}
