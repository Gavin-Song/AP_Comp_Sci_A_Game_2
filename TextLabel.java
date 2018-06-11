import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextLabel extends GUI
{
    private String text;
    private int h;
    private Font font;
    private GreenfootImage image;
    
    //TODO make image transparnet
    public TextLabel(String txt, int h) {
        this.text = txt;
        this.h = h;
        
        image = new GreenfootImage(this.getImage());
        this.setImage(image);
        this.getImage().scale(120, h);
        
        this.font = new Font(h / 2);
        this.image = this.getImage();
    }
    
    public void act() 
    {
        GreenfootImage img = new GreenfootImage(image);
        this.setImage(img);
        img = this.getImage();
        
        System.out.println(this.text);
        img.setFont(font);
        img.setColor(Color.BLACK);
        img.drawString(this.text, 8, this.h / 2 + 4);
    }    
    
    public void updateText(String s) {
        this.text = s;
    }
}
