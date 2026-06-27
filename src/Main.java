import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[] args)
    {
        JFrame window=new JFrame();
        GameMenu panel=new GameMenu(window);
        window.add(panel);
        window.pack();
        panel.setBackground(Color.black);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);

    }
}