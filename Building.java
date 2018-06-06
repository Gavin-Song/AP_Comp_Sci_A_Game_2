import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Building here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Building extends MilitaryUnit
{
    private int x;
    private int y;
    
    public Building(Country country, int x, int y) {
        super(country);
        
        this.x = x;
        this.y = y;
    }
}
