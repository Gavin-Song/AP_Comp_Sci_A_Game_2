import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MapWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapWorld extends World
{
    private WorldMap map;
    /**
     * Constructor for objects of class MapWorld.
     * 
     */
    public MapWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 806, 1); 
        getBackground().scale(Config.WORLD_WIDTH, Config.WORLD_HEIGHT);
        map = new WorldMap();
        addObject(map, getWidth()/2, getHeight()/2);
    }
}
