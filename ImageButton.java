import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ImageButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageButton extends Button
{
    private String image;
    private int w;
    private int h;
    
    public ImageButton(String image, int w, int h) {
        this.image = image;
        this.w = w;
        this.h = h;
        
        this.setImage(image);
        this.getImage().scale(w, h);
    }
}
