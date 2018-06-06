import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Factory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Factory extends Building
{
    private static int FACTORY_WIDTH = 100;
    private static int FACTORY_HEIGHT = 100;
    
    public Factory(Country country, int x, int y){
        super(country, x, y);
        this.getImage().scale(FACTORY_WIDTH, FACTORY_HEIGHT);
    }
    
    /**
     * Act - do whatever the Factory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
