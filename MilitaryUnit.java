import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MilitaryUnit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MilitaryUnit extends Actor
{
    private Country country;  // Country unit belongs to
    
    public MilitaryUnit(Country country) {
        this.country = country;
    }
}
