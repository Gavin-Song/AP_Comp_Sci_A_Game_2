import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MapWorld extends World
{
    int frames = 0;
    /**
     * Constructor for objects of class MapWorld.
     * 
     */
    public MapWorld()
    {    
        super(1500, 806, 1); 
        getBackground().scale(Config.WORLD_WIDTH, Config.WORLD_HEIGHT);
        getBackground().setTransparency(200);        
    }
    public void act()
    {
        
    }
}
