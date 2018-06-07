import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MobileUnit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MobileUnit extends MilitaryUnit
{
    public MobileUnit(Country country, int hp) {
        super(country, hp);
    }
    void moveTo(int x, int y) {
        turnTowards(x,y);
        while(!(getX() == x && getY() == y)){
            move(5);
        }
    }
}
