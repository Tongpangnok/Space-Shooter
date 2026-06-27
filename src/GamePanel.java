import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;



public class GamePanel extends JPanel implements Runnable{

    KeyHandler kh=new KeyHandler(this);
    int x=200;
    int y=400;
    int speed=4;
    int FPS=60;
    public int bestScore=0;
    Random random=new Random();
    int exploding_index=-1;
    boolean collision;
   public Rectangle player=new Rectangle(x,y,50,50);
  public  Object[] object=new Object[10];
  public boolean playeralive=true;
    HpBar[] hpBar=new HpBar[10];
Bullet bullet=new Bullet(this);
   Mouse mouse=new Mouse();
    Thread gameThread;
    Sound sound=new Sound();
   BufferedImage image1;
   BufferedImage image2;
   UI ui=new UI(this);
JFrame window;
   public int point=0;
   GameOver gameOver;
   GameMenu menu;

   int count=0;
   boolean exploding=false;
    public GamePanel(JFrame window){
        this.setPreferredSize(new Dimension(500,500));
        this.setFocusable(true);
        this.window=window;
        this.gameOver=new GameOver(this,window,menu);
        try {
            image1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/spaceship.png"));
            image2=ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/explode.png"));
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        for(int i=0;i< object.length;i++)
        {
            object[i]=new Object();
            object[i].rect.x = random.nextInt(400);
            object[i].rect.y = -i * 120;
            hpBar[i] = new HpBar(object[i]);
        }
        sound.setFile();
        this.addKeyListener(kh);
        this.addKeyListener(gameOver);
        this.addMouseListener(mouse);
    }
   public void gameLoop(){
        gameThread=new Thread(this);
        gameThread.start();
   }

   public void update() {

       if (kh.up == true) {
           player.y -= speed;

       }

       if (kh.down == true) {
           player.y += speed;


       }

       if (kh.left == true) {
           player.x -= speed;


       }

       if (kh.right == true) {
           player.x += speed;

       }
       if(exploding)
       {
           count++;
       }
       for (int i = 0; i < object.length; i++) {
           if (playeralive && player.intersects(object[i].rect)) {
               sound.setExplode();
               sound.explosion();
               playeralive = false;
           }

           if (mouse.mouseClick && !bullet.active) {
               playEffect();
               bullet.bul.x = player.x + player.width / 2;
               bullet.bul.y = player.y;

               bullet.active = true;
               mouse.mouseClick = false;
           }

           if (bullet.active) {
               bullet.bul.y -= 10;
               if (object[i].alive && bullet.bul.intersects(object[i].rect)) {
                   bullet.active = false;
                   hpBar[i].hp.width -= 10;
                   if (hpBar[i].hp.width <= 0) {
                       sound.setExplode();
                       sound.explosion();
                       point++;
                       bestScore=Math.max(bestScore,point);
                       object[i].alive = false;
                       exploding=true;
                       exploding_index=i;
                       count=0;
                   }
               }
               if (bullet.bul.y + bullet.bul.height < 0) {
                   bullet.active = false;
               }
           }

           if (object[i].alive) {
               object[i].rect.y += 1;
               hpBar[i].bar.y = object[i].rect.y - 10;
               hpBar[i].hp.y = object[i].rect.y - 10;
               hpBar[i].bar.x = object[i].rect.x - 5;
               hpBar[i].hp.x = object[i].rect.x - 5;

               if (object[i].alive && object[i].rect.y > getHeight()) {
                   object[i].rect.y = -object[i].rect.height;
                   hpBar[i].hp.width=60;
               }

           }
       }
   }
 public void playEffect(){
        sound.playGun();
 }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (playeralive) {
            g.drawImage(image1, player.x, player.y, player.width, player.height, null);
        }
        if (bullet.active) {
            bullet.draw(g);
        }
        for (int i = 0; i < object.length; i++) {
            if (object[i].alive) {
                object[i].draw(g);
                hpBar[i].draw(g);
            }
            if (i==exploding_index && exploding) {
                if (count <= 120) {
                    g.drawImage(image2, object[i].rect.x, object[i].rect.y, object[i].rect.width, object[i].rect.height, null);

                }
                else{
                    exploding = false;
                    exploding_index=-1;
                    count=0;
                }
            }
            if (playeralive) {
                ui.draw(g);
            }
            if (!playeralive && gameOver.start == true) {
                g.drawImage(image2,player.x,player.y,player.width,player.height,null);
                gameOver.begin = true;
                gameOver.draw(g);
            }
        }
    }
    public void resetGame() {
        point = 0;
        playeralive = true;

        player.x = 200;
        player.y = 400;
        gameOver.begin=false;
        bullet.active = false;

        for(int i = 0; i < object.length; i++) {
            object[i] = new Object();
            object[i].rect.x = random.nextInt(400);
            object[i].rect.y = -i * 120;
            object[i].alive = true;

            hpBar[i] = new HpBar(object[i]);
        }

        gameOver.start = true;
    }
    @Override
    public void run() {
        double interval=1000000000.0/FPS;
        double current;
        double elapseTime;
        double delta=0.0;
        double lastTime=System.nanoTime();
        while(gameThread!=null)
        {
            current=System.nanoTime();
            elapseTime=current-lastTime;
            delta+=elapseTime/interval;
            lastTime=current;
            if(delta>=1)
            {
                update();
                repaint();
                delta--;
            }
        }
    }
}
