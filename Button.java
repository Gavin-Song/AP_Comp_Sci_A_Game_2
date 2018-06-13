import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Button extends GUI
{
    public void onClick() {
    }
    
    public boolean isClicked() {
        return Greenfoot.mouseClicked(this);
    }
    
    public void act() {
    }
}
