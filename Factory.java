import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Factory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Factory extends Building
{
    private static int FACTORY_WIDTH = 100;
    private static int FACTORY_HEIGHT = 100;
    
    public Factory(Country country, int hp){
        super(country,hp);
        this.getImage().scale(FACTORY_WIDTH, FACTORY_HEIGHT);
    }
    
    //public abstract void spawnUnit(String type, int x, int y);
}
