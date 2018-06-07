import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Building here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Building extends MilitaryUnit
{
    public Building(Country country, int hp) {
        super(country,hp);
        
        this.getImage().scale(10, 10);
    }
}
