import greenfoot.*;
import java.util.*;

public class LeaderBoard extends Actor
{
    private int h;
    private Font font;
    private GreenfootImage image;
    
    //TODO make image transparnet
    public LeaderBoard(int h) {
        this.h = h;
        
        image = new GreenfootImage(this.getImage());
        this.setImage(image);
        this.getImage().scale(400, h); //500 = width

        this.font = new Font(h / 8);
        this.image = this.getImage();
    }

    public void act() 
    {
        if (Math.random() > 0.05) return;
        
        GreenfootImage img = new GreenfootImage(image);
        this.setImage(img);
        img = this.getImage();
        
        //System.out.println(this.text);
        img.setFont(font);
        img.setColor(Color.BLACK);
        
        ArrayList<String> data = MapWorld.getGameState().getLeaderboardData();
        for (int i=0; i<data.size(); i++) {
            img.drawString(data.get(i), 8, this.h / 8 * i + this.h / 4);
        }
    }    
}
