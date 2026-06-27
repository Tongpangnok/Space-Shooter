import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.net.URL;

public class Sound {
    Clip clip1;
    Clip clip2;
    Clip clip3;
    Clip clip4;
    URL[] url=new URL[4];
    Sound(){
       try {
           url[0] = getClass().getClassLoader().getResource("sound/lazer.wav");
           url[1]=getClass().getClassLoader().getResource("sound/explode.wav");
           url[2]=getClass().getClassLoader().getResource("sound/option.wav");
           url[3]=getClass().getClassLoader().getResource("sound/option2.wav");

       }catch(Exception e)
       {
           e.printStackTrace();
       }
    }
    public void setFile(){
        try {
            AudioInputStream ais=AudioSystem.getAudioInputStream(url[0]);
            clip1=AudioSystem.getClip();
            clip1.open(ais);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void setExplode(){
        try {
            AudioInputStream ais=AudioSystem.getAudioInputStream(url[1]);
            clip2=AudioSystem.getClip();
            clip2.open(ais);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setOption(){
        try {
            AudioInputStream ais=AudioSystem.getAudioInputStream(url[2]);
            clip3=AudioSystem.getClip();
            clip3.open(ais);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void setOption2(){
        try {
            AudioInputStream ais=AudioSystem.getAudioInputStream(url[3]);
            clip4=AudioSystem.getClip();
            clip4.open(ais);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void playGun(){
        clip1.stop();
        clip1.setFramePosition(0);
       clip1.start();
    }
    public void explosion(){
        clip2.start();
    }
    public void playOption(){
        clip3.start();
    }
    public void playOption2(){
        clip4.start();
    }
}
